package com.lcms.modules.system.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.application.BaseApplication;
import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.domain.enums.DelFlagEnum;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.exception.ServiceException;
import com.lcms.modules.system.role.service.SysRoleService;
import com.lcms.modules.system.role.dao.SysRoleDao;
import com.lcms.modules.system.role.domain.entity.SysRole;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.domain.enums.SystemErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseApplication implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public BasePageDto<SysRole> queryRoles(SysRole sysRole) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(sysRole.getName())){
            wrapper.like("name", sysRole.getName());
        }
        IPage<SysRole> sysRoleIPage = sysRoleDao.selectPage(new Page<SysRole>(sysRole.getPageNum(),sysRole.getPageSize()),wrapper);
        return returnBaseResult(sysRoleIPage.getRecords(),sysRoleIPage.getTotal());
    }

    @Override
    public void delete(List<String> sids) {
        for (String sid: sids) {
            SysRole sysRole = sysRoleDao.selectById(sid);
            if(null == sysRole){
                throw new ServiceException(SystemErrorCode.E23005,SystemErrorCode.E23005.getText());
            }
//            sysRoleDao.deleteById(sid);
        }
    }

    @Override
    public int insetRole(SysRole sysRole) {
        UserEntity userInfo = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        //sysRole.setSort(1);
       // sysRole.setStatus("0");
        sysRole.setDelFlag(DelFlagEnum.CREATE);
        //sysRole.setCreateUser(userInfo.getUsername());
        sysRole.setCreateTime(new Date(System.currentTimeMillis()));
        return sysRoleDao.insert(sysRole);
    }

    @Override
    public SysRole selectById(Long id) {
        SysRole sysRole = sysRoleDao.selectByPrimaryKey(id);
        return sysRole;
    }

    @Override
    public int update(SysRole sysRole) {
        UserEntity userInfo = (UserEntity) SecurityUtils.getSubject().getPrincipal();
       // sysRole.setUpdateTime(new Date(System.currentTimeMillis()));
        //sysRole.setUpdateUser(userInfo.getUsername());
        return sysRoleDao.updateByPrimaryKeySelective(sysRole);
    }

    public SysRole queryRoleBySid(String sid) {
        SysRole sysRole = sysRoleDao.selectById(sid);
        return sysRole;
    }

}

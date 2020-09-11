package com.lcms.modules.system.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.role.service.SysRoleService;
import com.lcms.modules.system.role.dao.SysRoleDao;
import com.lcms.modules.system.role.domain.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> queryRoles(BaseVo baseVo) {
        IPage<SysRole> sysRoleIPage = sysRoleDao.selectPage(new Page<>(baseVo.getPageSize(),baseVo.getPageNum()),null);
        return sysRoleIPage.getRecords();
    }

    @Override
    public void delete(String id) {
        sysRoleDao.deleteById(id);
    }
}

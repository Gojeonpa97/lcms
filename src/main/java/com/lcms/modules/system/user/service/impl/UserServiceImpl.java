package com.lcms.modules.system.user.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.application.BaseApplication;
import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.exception.ServiceException;
import com.lcms.common.shiro.utils.ShiroUtils;
import com.lcms.modules.system.user.dao.UserDao;

import com.lcms.modules.system.user.domain.dto.PwdDto;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.domain.enums.UserErrorCodeEnum;
import com.lcms.modules.system.user.domain.vo.UserQueryVo;
import com.lcms.modules.system.user.service.UserService;

import java.util.List;

import com.lcms.modules.system.user.utils.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseApplication implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserEntity findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public BasePageDto<UserEntity> queryUsers(UserQueryVo userQueryVo) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userQueryVo, user);
    	QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
    	wrapper.eq("del_flag", 0);
		if(user.getSid() != null){
			wrapper.eq("sid", user.getSid());
		}
    	if(StringUtils.isNotBlank(user.getUsername())){
    		wrapper.like("username", user.getUsername());
    	}
		if(StringUtils.isNotBlank(user.getLoginName())){
			wrapper.like("login_name", user.getLoginName());
		}
    	if(StringUtils.isNotBlank(user.getEmail())){
    		wrapper.like("email", user.getEmail());
    	}
    	if(StringUtils.isNotBlank(user.getSex())){
    		wrapper.like("sex", user.getSex());
    	}
        IPage<UserEntity> list = userDao.selectPage(new Page<UserEntity>(userQueryVo.getPageNum(),userQueryVo.getPageSize()), wrapper);
        return returnBaseResult(list.getRecords(),list.getTotal());
    }

    @Override
    public void delete(List<String> sids) {
    	for (String sid : sids){
			UserEntity validEntity = userDao.selectById(sid);
			if(null == validEntity){
				throw new ServiceException(UserErrorCodeEnum.E22000,UserErrorCodeEnum.E22000.getText());
			}
			validEntity.preUpdate("");
			userDao.updateByPrimaryKey(validEntity);
		}
    }

	@Override
	public void insert(UserEntity user) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
		UserEntity sysUser = ShiroUtils.getSysUser();
        // 默认密码 123456
        String pwd = "123456";
        String md5Pwd = PasswordUtil.generatePassword(pwd);
        wrapper.eq("login_name",user.getLoginName());
        UserEntity userEntity = userDao.selectOne(wrapper);
        if(null != userEntity){
            throw new ServiceException(UserErrorCodeEnum.E22006,UserErrorCodeEnum.E22006.getText());
        }
        user.setStatus("0");
		user.preCreate("");//TODO
        user.setPassword(md5Pwd);
//		userDao.insert(user);
	}

	@Override
	public void update(UserEntity user) {
		UserEntity userInfo = (UserEntity) SecurityUtils.getSubject().getPrincipal();
		user.preUpdate("");
		userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public void updatePwd(PwdDto pwdDto) {

	}

	@Override
	public void resetPwd(List<String> sids) {
		// 默认密码 123456
		String pwd = "123456";
		String md5Pwd = PasswordUtil.generatePassword(pwd);
		for (String ids :sids){
			UserEntity userEntity = userDao.selectById(ids);
			if(userEntity == null) {
				throw new ServiceException(UserErrorCodeEnum.E22000, UserErrorCodeEnum.E22000.getText());
			}
			userEntity.setPassword(md5Pwd);
			userEntity.preUpdate("");
			userDao.updateByPrimaryKey(userEntity);
		}
	}
}

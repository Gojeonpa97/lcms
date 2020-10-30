package com.lcms.modules.system.user.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.utils.MD5Util;
import com.lcms.modules.system.log.domain.entity.SysLog;
import com.lcms.modules.system.user.dao.UserDao;

import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserEntity findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public IPage<UserEntity> queryUsers(UserEntity user) {
    	QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
    	if(StringUtils.isNotBlank(String.valueOf(user.getSid()))){
    		wrapper.like("id", user.getSid());
    	}
    	if(StringUtils.isNotBlank(user.getUsername())){
    		wrapper.like("username", user.getUsername());
    	}
    	if(StringUtils.isNotBlank(user.getEmail())){
    		wrapper.like("email", user.getEmail());
    	}
    	if(StringUtils.isNotBlank(user.getSex())){
    		wrapper.like("sex", user.getSex());
    	}
        IPage<UserEntity> list = userDao.selectPage(new Page<>(user.getPageSize(),user.getPageNum()), wrapper);
        return list;
    }

    @Override
    public void delete(Long id) {
        userDao.updateStatus(id);
    }

	@Override
	public int insertUser(UserEntity user) {
		UserEntity userInfo = (UserEntity) SecurityUtils.getSubject().getPrincipal();
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		user.setDelFlag("0");
		user.setStatus("0");
		user.setUserType("00");
		user.setCreateUser(userInfo.getUsername());
		user.setCreateTime(new Date(System.currentTimeMillis()));
		return userDao.insert(user);
	}

	@Override
	public UserEntity selectByPrimaryKey(Long id) {
		UserEntity user = userDao.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public int updateByPrimaryKey(UserEntity user) {
		UserEntity userInfo = (UserEntity) SecurityUtils.getSubject().getPrincipal();
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		user.setUpdateUser(userInfo.getUsername());
		System.out.println(new Date(System.currentTimeMillis()));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		return userDao.updateByPrimaryKeySelective(user);
	}
}

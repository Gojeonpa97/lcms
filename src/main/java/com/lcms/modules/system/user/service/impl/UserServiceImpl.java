package com.lcms.modules.system.user.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.user.dao.UserDao;

import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
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
    public IPage<UserEntity> queryUsers(BaseVo baseVo) {
        IPage<UserEntity> list = userDao.selectPage(new Page<>(baseVo.getPageSize(),baseVo.getPageNum()), null);
        return list;
    }

    @Override
    public void delete(String id) {
        userDao.deleteById(id);
    }
}

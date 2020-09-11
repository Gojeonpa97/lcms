package com.lcms.modules.system.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcms.modules.system.user.domain.entity.UserEntity;

public interface UserDao extends BaseMapper<UserEntity> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    UserEntity findUserByName(String username);
}
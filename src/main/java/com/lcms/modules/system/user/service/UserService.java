package com.lcms.modules.system.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.user.domain.entity.UserEntity;

import java.util.List;

public interface UserService {


    UserEntity findUserByName(String username);

    IPage<UserEntity> queryUsers(BaseVo baseVo);

    void delete(String id);

}

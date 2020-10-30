package com.lcms.modules.system.user.service;

import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.modules.system.user.domain.dto.PwdDto;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.domain.vo.UserQueryVo;

import java.util.List;

public interface UserService {


    UserEntity findUserByName(String username);

    BasePageDto<UserEntity> queryUsers(UserQueryVo userQueryVo);

    void delete(List<String> sids);
    
    void insert(UserEntity user);
    
    void update(UserEntity record);

    /**
     * 重置密码
     * @param
     * @return
     */
    void updatePwd(PwdDto pwdDto);

    /**
     * 重置密码
     * @param
     * @return
     */
    void resetPwd(List<String> sids);
}

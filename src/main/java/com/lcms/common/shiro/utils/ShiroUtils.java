package com.lcms.common.shiro.utils;

import com.lcms.modules.system.user.domain.entity.UserEntity;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

    public static UserEntity getSysUser(){
        return (UserEntity)SecurityUtils.getSubject().getPrincipal();
    }

    public static String getSysUsername(){
        return getSysUser().getUsername();
    }
    /**
     * 获取当前登录用户id
     *
     * @return 用户id
     */
    public static Long getSysUserId() {
        return getSysUser().getId();
    }
}

package com.lcms.modules.system.login.domain.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginVo {

    /**
     * 登录账户
     */
    @NotBlank(message="用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message="密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @NotBlank(message="验证码不能为空")
    private String code;
}

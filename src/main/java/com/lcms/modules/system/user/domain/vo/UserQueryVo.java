package com.lcms.modules.system.user.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lcms.common.domain.vo.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@TableName(value = "sys_user")
@Getter
@Setter
public class UserQueryVo extends BaseVo {

    /**
     * 主键sid
     */
    private Integer sid;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户类型（00系统用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 备注说明
     */
    private String description;

}

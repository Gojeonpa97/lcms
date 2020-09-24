package com.lcms.modules.system.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lcms.common.domain.vo.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
@TableName(value = "sys_user")
@Getter
@Setter
public class UserEntity extends BaseVo implements Serializable{

    private static final long serialVersionUID = 3242632700065522717L;
    /**
     * 用户ID
     */
    private Long sid;

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
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注说明
     */
    private String description;

}
package com.lcms.modules.system.role.domain.entity;

import com.lcms.common.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user_rel
 * @author 
 */
@Getter
@Setter
public class SysUserRel extends BaseEntity {

    private static final long serialVersionUID = -2277363520131335655L;

    /**
     * 角色SID
     */
    private Integer roleSid;

    /**
     * 备注说明
     */
    private String description;

    /**
     * 用户SID
     */
    private Integer userSid;



}
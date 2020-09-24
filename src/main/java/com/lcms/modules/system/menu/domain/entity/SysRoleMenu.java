package com.lcms.modules.system.menu.domain.entity;

import com.lcms.common.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role_menu
 * @author 
 */
@Getter
@Setter
public class SysRoleMenu extends BaseEntity {

    private static final long serialVersionUID = 6900395073917687816L;
    /**
     * 角色SID
     */
    private Integer roleSid;

    /**
     * 菜单SID
     */
    private Integer menuSid;

    /**
     * 备注说明
     */
    private String description;


}
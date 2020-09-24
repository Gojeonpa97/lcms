package com.lcms.modules.system.menu.domain.entity;

import com.lcms.common.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * sys_menu
 * @author 
 */
@Getter
@Setter
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = -7095675351690141191L;

    /**
     * 父菜单ID
     */
    private Integer pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单级别：父节点(PARENT)子节点(CHILD)按钮(BUTTON) 类：MenuLevel
     */
    private String menuLevel;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 备注说明
     */
    private String description;


}
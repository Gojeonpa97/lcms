package com.lcms.modules.system.role.domain.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role
 * @author 
 */
@Getter
@Setter
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = -7439072351002142508L;
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 备注
     */
    private String description;

}
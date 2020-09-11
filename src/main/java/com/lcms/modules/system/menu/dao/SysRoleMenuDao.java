package com.lcms.modules.system.menu.dao;

import com.lcms.modules.system.menu.domain.entity.SysRoleMenu;

public interface SysRoleMenuDao {
    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(SysRoleMenu key);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}
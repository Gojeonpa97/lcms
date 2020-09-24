package com.lcms.modules.system.menu.dao;

import com.lcms.modules.system.menu.domain.entity.SysRoleMenu;

public interface SysRoleMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}
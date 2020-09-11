package com.lcms.modules.system.role.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcms.modules.system.role.domain.entity.SysRole;

public interface SysRoleDao extends BaseMapper<SysRole> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}
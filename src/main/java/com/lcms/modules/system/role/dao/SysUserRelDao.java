package com.lcms.modules.system.role.dao;

import com.lcms.modules.system.role.domain.entity.SysUserRel;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRel record);

    int insertSelective(SysUserRel record);

    SysUserRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRel record);

    int updateByPrimaryKey(SysUserRel record);
}
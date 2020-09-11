package com.lcms.modules.system.menu.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcms.modules.system.menu.domain.dto.SysMenuDto;
import com.lcms.modules.system.menu.domain.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuDao extends BaseMapper<SysMenu> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenuDto> findAllMenuByUserId(@Param("userId") String userId);
}
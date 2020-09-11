package com.lcms.modules.system.log.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.modules.system.log.domain.entity.SysLog;

public interface SysLogDao extends BaseMapper<SysLog> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    IPage<SysLog> queryLogList(SysLog record);
}
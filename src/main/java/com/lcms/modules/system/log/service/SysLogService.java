package com.lcms.modules.system.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.log.domain.entity.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

public interface SysLogService {


    /**
     * @param joinPoint
     * @param methodName    方法名称
     * @param module        模块
     * @param description   描述
     */
    void save(ProceedingJoinPoint joinPoint,String methodName, String logType, String module, String description);

    IPage<SysLog> queryLogs(SysLog sysLog,BaseVo baseVo);

    void delete(List<String> ids);
}

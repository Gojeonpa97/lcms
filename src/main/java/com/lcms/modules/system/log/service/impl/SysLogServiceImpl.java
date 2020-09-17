package com.lcms.modules.system.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.utils.IPUtils;
import com.lcms.modules.system.log.dao.SysLogDao;
import com.lcms.modules.system.log.domain.entity.SysLog;
import com.lcms.modules.system.log.service.SysLogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    @Override
    @Transactional
    public void save(ProceedingJoinPoint joinPoint, String methodName, String logType, String module, String description) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        SysLog log = new SysLog();
        log.setLogType(logType);
        log.setDescription(description);
        log.setModule(module);
        String ip = IPUtils.getIpAddr(request);
        log.setIp(ip);
        // 获取客户端操作系统
        log.setOs(userAgent.getOperatingSystem().getName());
        // 获取客户端浏览器
        log.setBrowser(userAgent.getBrowser().getName());
        log.setCreateTime(new Date());
        log.setContent(operateContent(joinPoint, methodName, ip, request));
        //sysLogDao.insert(log);
    }

    @Override
    public IPage<SysLog> queryLogs(SysLog sysLog,BaseVo baseVo) {
        QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
        if(StringUtils.isNoneBlank(sysLog.getModule())){
            wrapper.like("module",sysLog.getModule());
        }
        if(StringUtils.isNotBlank(sysLog.getLogType())){
            wrapper.like("log_type",sysLog.getLogType());
        }
        IPage<SysLog> sysLogIPage = sysLogDao.selectPage(new Page<>(baseVo.getPageSize(),baseVo.getPageNum()), wrapper);
        return sysLogIPage;
    }

    @Override
    public void delete(List<String> ids) {
        for(String id : ids){
            SysLog sysLog = sysLogDao.selectById(id);
            if(sysLog == null){

            }
        }

    }

    public String operateContent(ProceedingJoinPoint joinPoint, String methodName, String ip, HttpServletRequest request) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        StringBuffer bf = new StringBuffer();
        if (params != null && params.length > 0) {
            Enumeration<String> paraNames = request.getParameterNames();
            while (paraNames.hasMoreElements()) {
                String key = paraNames.nextElement();
                bf.append(key).append("=");
                bf.append(request.getParameter(key)).append("&");
            }
            if (StringUtils.isBlank(bf.toString())) {
                bf.append(request.getQueryString());
            }
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), ip);
    }
}

package com.lcms.common.exception;

import com.lcms.common.domain.IEnum;
import com.lcms.common.utils.IPUtils;
import com.lcms.common.utils.SpringUtils;
import com.lcms.modules.system.log.dao.SysLogDao;
import com.lcms.modules.system.log.domain.entity.SysLog;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 7597648963886392921L;

    private IEnum errorCode;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(IEnum errorCode,String message){
        super(message);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String username = null;

        try {
//            SpringUtils.getBean();
        } catch (Exception e) {// 如果登录则用户是为空
//			e.printStackTrace();
            username = "";
        }
        String ip = IPUtils.getIpAddr(request);

        SysLog log = new SysLog();
        log.setLogType("异常日志");
        log.setModule(errorCode.getText());
        log.setDescription(message);
        log.setIp(ip);
        log.setContent(message);
        SysLogDao sysLogDao = SpringUtils.getBean(SysLogDao.class);
        sysLogDao.insert(log);

        this.errorCode=errorCode;
    }
    public IEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(IEnum errorCode) {
        this.errorCode = errorCode;
    }
}

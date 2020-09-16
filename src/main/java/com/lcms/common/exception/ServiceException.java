package com.lcms.common.exception;

import com.lcms.common.domain.IEnum;
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
        this.errorCode=errorCode;
    }
    public IEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(IEnum errorCode) {
        this.errorCode = errorCode;
    }
}

package com.lcms.common.web;

import com.lcms.common.domain.IEnum;
import com.lcms.common.domain.dto.BaseResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {

    public <T> BaseResult<T> returnSucceed(T t) {
        return this.returnSucceed(t, null);
    }

    public <T> BaseResult<T> returnSucceed(T t, String successMessage) {
        BaseResult<T> base = new BaseResult<T>();
        base.setSuccess(true);
        base.setCode("0");
        base.setData(t);
        base.setSuccessMessage(successMessage);
        return base;
    }

    public <T> BaseResult<T> returnFailed(IEnum errorCode, String errorMessage) {
        BaseResult<T> base = new BaseResult<T>();
        base.setSuccess(false);
        base.setErrorCode(errorCode);
        base.setErrorMessage(errorMessage);
        return base;
    }

}

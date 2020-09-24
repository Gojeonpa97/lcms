package com.lcms.common.web;

import com.google.common.base.Throwables;
import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.domain.enums.ErrorCodeEnum;
import com.lcms.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ControllerAdvice
public class LcmsExceptionHandler extends BaseController{

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(RuntimeException ex) {
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ErrorCodeEnum.E10001, ErrorCodeEnum.E10001.getText());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(Exception ex) {
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ErrorCodeEnum.E10001, ErrorCodeEnum.E10001.getText());
    }

//    @ExceptionHandler(ControllerException.class)
//    @ResponseBody
//    public <T> BaseResult<T> handleException(ControllerException ex) {
//        log.error(Throwables.getStackTraceAsString(ex));
//        return returnFailed(ex.getErrorCode(), ex.getMessage());
//    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(ServiceException ex) {
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fes = bindingResult.getFieldErrors();
        String message = handlerMessage(fes);
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ErrorCodeEnum.E10002, ErrorCodeEnum.E10002.getText() + message.substring(0, message
                .length() - 1));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fes = bindingResult.getFieldErrors();
        String message = handlerMessage(fes);
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ErrorCodeEnum.E10002, ErrorCodeEnum.E10002.getText() + " " + message.substring(0, message.length()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public <T> BaseResult<T> handleException(HttpMessageNotReadableException ex) {
        log.error(Throwables.getStackTraceAsString(ex));
        return returnFailed(ErrorCodeEnum.E10002, ErrorCodeEnum.E10002.getText() + ex.getMessage());
    }


    private String handlerMessage(List<FieldError> fes) {
        StringBuffer message = new StringBuffer();
        for (FieldError fieldError : fes) {
            // message.append(" 字段:");
            // message.append(fieldError.getField());
            // message.append(" 验证错误:");
            message.append(fieldError.getDefaultMessage());
            break;
            // message.append(",");
        }
        return message.toString();
    }
}

package com.lcms.modules.system.login.service.impl;


import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.exception.ServiceException;
import com.lcms.common.utils.MD5Util;
import com.lcms.modules.system.login.domain.enums.LoginErrorCodeEnum;
import com.lcms.modules.system.login.domain.vo.LoginVo;
import com.lcms.modules.system.login.service.LoginService;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public BaseResult<Object> login(LoginVo loginVo, HttpServletRequest request) {
        BaseResult<Object> result = new BaseResult<>();
        try {
            if(!CaptchaUtil.ver(loginVo.getCode(),request)){
                throw new ServiceException(LoginErrorCodeEnum.E10208,LoginErrorCodeEnum.E10208.getText());
            }
            if(StringUtils.isBlank(loginVo.getUsername())){
                throw new ServiceException(LoginErrorCodeEnum.E10202,LoginErrorCodeEnum.E10202.getText());
            }
            UserEntity user = userService.findUserByName(loginVo.getUsername());
            if(user == null){
                throw new ServiceException(LoginErrorCodeEnum.E10202,LoginErrorCodeEnum.E10202.getText());
            }
            UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUsername(), MD5Util.encrypt(loginVo.getPassword()).toCharArray());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            result.setSuccess(true);
            result.setCode("0");
            return result;
        }catch(AuthenticationException e){
            log.error("用户名或密码错误");
            throw new ServiceException(LoginErrorCodeEnum.E10202,LoginErrorCodeEnum.E10202.getText());
        }catch (RuntimeException e){
            log.error(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}

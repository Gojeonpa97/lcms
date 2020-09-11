package com.lcms.modules.system.login.service.impl;

import com.lcms.common.domain.entity.BaseResult;
import com.lcms.common.utils.MD5Util;
import com.lcms.modules.system.login.domain.vo.LoginVo;
import com.lcms.modules.system.login.service.LoginService;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
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
        if(StringUtils.isBlank(loginVo.getUsername())){

        }
        UserEntity user = userService.findUserByName(loginVo.getUsername());
        if(user == null){

        }
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUsername(), MD5Util.encrypt(loginVo.getPassword()).toCharArray());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            log.error("账户不存在");
            result.setErrorMessage("账户不存在");
        }catch (DisabledAccountException e){
            log.error("账户已禁用");
            result.setErrorMessage("账户已禁用");
        }catch(IncorrectCredentialsException e){
            log.error("密码错误");
            result.setErrorMessage("密码错误");
        }catch (RuntimeException e){
            log.error("未知错误");
            result.setErrorMessage("未知错误");
        }
        result.setSuccess(true);
        result.setCode("0");
        return result;
    }
}

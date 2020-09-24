package com.lcms.modules.system.login.web;


import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.log.annotation.Log;
import com.lcms.common.web.BaseAction;
import com.lcms.modules.system.login.domain.vo.LoginVo;
import com.lcms.modules.system.login.service.LoginService;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends BaseAction {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @Log(logType = "登录日志", module = "用户登录", description = "用户登录 -> 用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }
        return "login";
    }

    @Log(logType = "登录日志", module = "用户登录", description = "用户登录 -> 用户登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult<Object> logining(@RequestBody LoginVo loginVo, HttpServletRequest request){
        return this.loginService.login(loginVo,request);
    }

    @RequestMapping(value = "/logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}

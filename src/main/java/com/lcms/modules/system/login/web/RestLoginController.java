package com.lcms.modules.system.login.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "manager")
public class RestLoginController {


    @RequestMapping(value = "/login")
    public String hotf(HttpServletRequest request) throws Exception {
        if(SecurityUtils.getSubject().isAuthenticated()){
            return "index2";
        }
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) throws Exception {
        return "index2";
    }

    @RequestMapping(value = "/home")
    public String home(HttpServletRequest request) throws Exception {
        return "home";
    }

}

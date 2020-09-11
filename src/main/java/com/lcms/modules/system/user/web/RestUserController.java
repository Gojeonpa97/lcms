package com.lcms.modules.system.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sys")
public class RestUserController {


    @RequestMapping(value = "/user")
    public String sysUser(){
        return "sys/user/userList";
    }

    @RequestMapping("/userAdd")
    public String userAdd(){
        return "sys/user/user_add";
    }
}

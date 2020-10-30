package com.lcms.modules.system.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcms.modules.system.user.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sys")
public class RestUserController {

	@Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String sysUser(HttpServletRequest request)throws Exception{
        return "sys/user/userList";
    }

    @RequestMapping("/userAdd")
    public String userAdd(HttpServletRequest request)throws Exception{
        return "sys/user/user_add";
    }

    @RequestMapping("/userCenter")
    public String userCenter(HttpServletRequest request)throws Exception{
        return"sys/user/userinfo";
    }
    @RequestMapping("/profile")
    public String profile(HttpServletRequest request)throws Exception{
        return"sys/user/profile";
    }
    @RequestMapping("/userupdate")
    public String userupdate(HttpServletRequest request)throws Exception{
        return "sys/user/user_update";
    }

    @RequestMapping(value = "/userAddRole")
    public String userManageAddRole(HttpServletRequest request) throws Exception {
        return "sys/user/user_add_role";
    }
}

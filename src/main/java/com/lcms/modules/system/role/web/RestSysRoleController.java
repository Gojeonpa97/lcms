package com.lcms.modules.system.role.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sys")
public class RestSysRoleController {

    @RequestMapping(value = "/role")
    public String role(HttpServletRequest request) throws Exception{
        return "sys/role/roleList";
    }
    @RequestMapping(value = "/roleTree")
    public String roleTree(HttpServletRequest request) throws Exception{
        return "sys/role/roleTree";
    }
}

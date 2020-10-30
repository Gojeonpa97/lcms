package com.lcms.modules.system.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "sys")
public class RestSysMenuController {

    @RequestMapping("/menu")
    public String SysMenus()throws Exception{
        return "sys/menu/menuList";
    }
    @RequestMapping("/menuadd")
    public String menuAdd(HttpServletRequest request)throws Exception{
        return "sys/menu/menuAdd";
    }
}

package com.lcms.modules.system.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "sys")
public class RestSysMenuController {

    @RequestMapping("/menu")
    public String SysMenus()throws Exception{
        return "sys/menu/menuList";
    }
}

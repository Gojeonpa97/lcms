package com.lcms.modules.system.pub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/public")
public class PublicController {


    @RequestMapping(value = "/theme")
    public String theme(){
        return "frame/theme";
    }
}

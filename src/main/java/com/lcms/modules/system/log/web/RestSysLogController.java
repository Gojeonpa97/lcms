package com.lcms.modules.system.log.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "sys")
public class RestSysLogController {

    @RequestMapping(value = "/log")
    public String sysLogManager(HttpServletRequest request) throws Exception{
        return "sys/log/logList";
    }
}

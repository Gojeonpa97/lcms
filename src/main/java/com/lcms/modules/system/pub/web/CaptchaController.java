package com.lcms.modules.system.pub.web;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CaptchaController {

    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response)throws Exception{
        CaptchaUtil.out(request,response);
    }
}

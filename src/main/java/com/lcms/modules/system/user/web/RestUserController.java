package com.lcms.modules.system.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcms.common.log.annotation.Log;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;

@Controller
@RequestMapping(value = "/sys")
public class RestUserController {

	@Autowired
    private UserService userService;

    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 查询用户页面")
    @RequestMapping(value = "/user")
    public String sysUser()throws Exception{
        return "sys/user/userList";
    }

    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 添加(修改)用户页面")
    @RequestMapping("/userAdd")
    public String userAdd(Long id,Model model)throws Exception{
    	if(id!=null){
    		UserEntity user = userService.selectByPrimaryKey(id);
    		model.addAttribute("user", user);
    	}
        return "sys/user/user_add";
    }

    @RequestMapping("/userCenter")
    public String userCenter()throws Exception{
        return"sys/user/userinfo";
    }
}

package com.lcms.modules.system.role.web;

import com.lcms.modules.system.role.domain.entity.SysRole;
import com.lcms.modules.system.role.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sys")
public class RestSysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/role")
    public String role(HttpServletRequest request) throws Exception{
        return "sys/role/roleList";
    }
    @RequestMapping(value = "/roleTree")
    public String roleTree(HttpServletRequest request) throws Exception {
        return "sys/role/roleTree";
    }
    @RequestMapping(value = "/addRole")
    public String addRole(Long id,Model model) throws Exception{
        if(id!=null){
            SysRole sysRole = sysRoleService.selectById(id);
            model.addAttribute("sysRole",sysRole);
        }
        return "sys/role/role_add";
    }
}

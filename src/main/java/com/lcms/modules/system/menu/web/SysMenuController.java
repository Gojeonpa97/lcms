package com.lcms.modules.system.menu.web;

import com.lcms.modules.system.menu.domain.dto.SysMenuDto;
import com.lcms.modules.system.menu.service.SysMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "菜单")
    @ResponseBody
    @RequestMapping(value = "/findAllMenuByUserId")
    public List<SysMenuDto> findAllMenuByUserId(){
        List<SysMenuDto> allMenuByUserId = sysMenuService.findAllMenuByUserId();
        return allMenuByUserId;
    }
}

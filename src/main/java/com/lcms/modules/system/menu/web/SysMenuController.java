package com.lcms.modules.system.menu.web;


import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.menu.domain.dto.SysMenuDto;
import com.lcms.modules.system.menu.domain.entity.SysMenu;
import com.lcms.modules.system.menu.service.SysMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/sys/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "菜单")
    @ResponseBody
    @RequestMapping(value = "/findAllMenuByUserId")
    public BaseResult<Object> findAllMenuByUserId(){
        List<SysMenuDto> allMenuByUserId = sysMenuService.findAllMenuByUserId();
        return returnSucceed(allMenuByUserId);
    }

    @ApiOperation(value = "菜单")
    @ResponseBody
    @RequestMapping(value = "/findAllMenu")
    public BaseResult<Object> findAllMenu(){
        List<SysMenu> allMenu = sysMenuService.findAllMenu();
        return returnSucceed(allMenu);
    }
}

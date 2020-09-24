package com.lcms.modules.system.role.web;

import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.role.service.SysRoleService;
import com.lcms.modules.system.role.domain.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "v1/system/role/roles")
    public BaseResult<Object> queryRoles(BaseVo baseVo){
        List<SysRole> sysRoles = sysRoleService.queryRoles(baseVo);
        return returnSucceed(sysRoles);
    }

    @RequestMapping(value = "v1/system/role/delete")
    public BaseResult<Object> delete(String id){
//        sysRoleService.delete(id);
        return returnSucceed(null);
    }
}

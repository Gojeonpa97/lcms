package com.lcms.modules.system.role.web;

import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.exception.ControllerException;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.role.service.SysRoleService;
import com.lcms.modules.system.role.domain.entity.SysRole;
import com.lcms.modules.system.user.domain.enums.SystemErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "v1/system/role/roles")
    public BaseResult<Object> queryRoles(SysRole sysRole){
        BasePageDto<SysRole> sysRoles = sysRoleService.queryRoles(sysRole);
        return returnSucceed(sysRoles);
    }

    @RequestMapping(value = "v1/system/role/delete")
    public BaseResult<Object> delete(@RequestBody List<String> sids){
        if(sids == null || sids.isEmpty()){
            throw new ControllerException(SystemErrorCode.E23001,SystemErrorCode.E23001.getText());
        }
        sysRoleService.delete(sids);
        return returnSucceed(null);
    }


    @RequestMapping(value = "v1/system/role/insert")
    public void insert(SysRole sysRole){
        sysRoleService.insetRole(sysRole);
    }

    @RequestMapping(value = "v1/system/role/update")
    public void update(SysRole sysRole) {
        sysRoleService.update(sysRole);
    }
    @RequestMapping(value = "v1/system/role/queryRoleBySid")
    public BaseResult<Object> queryRoleBySid(String sid){
//        SysRole sysRole = sysRoleService.queryRoleBySid(sid);
        return returnSucceed(null);

    }
}

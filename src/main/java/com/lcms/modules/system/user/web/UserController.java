package com.lcms.modules.system.user.web;


import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.exception.ControllerException;
import com.lcms.common.log.annotation.Log;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.domain.enums.UserErrorCodeEnum;
import com.lcms.modules.system.user.domain.vo.UserQueryVo;
import com.lcms.modules.system.user.service.UserService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Log(logType = "操作日志", module = "系统管理", description = "用户管理 -> 查询用户")
    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/v1/system/user/queryUsers")
    public BaseResult<Object> queryUsers(@RequestBody UserQueryVo userQueryVo){
        BasePageDto<UserEntity> pageDto = userService.queryUsers(userQueryVo);
        return returnSucceed(pageDto);
    }

    @Log(logType = "操作日志", module = "系统管理", description = "用户管理 -> 删除用户")
    @RequestMapping(value = "/v1/system/user/delete")
    public BaseResult<String> delete(@RequestBody List<String> sids){
        if (sids == null || sids.isEmpty()) {
            throw new ControllerException(UserErrorCodeEnum.E22011, UserErrorCodeEnum.E22011.getText());
        }
        userService.delete(sids);
       return returnSucceed(null);
    }
    
    @Log(logType = "操作日志", module = "系统管理", description = "用户管理 -> 添加用户")
    @RequestMapping(value = "/v1/system/user/insert")
    public  BaseResult insertUser(@RequestBody UserEntity user){
    	userService.insert(user);
    	return returnSucceed(null);
    }

    @Log(logType = "操作日志", module = "系统管理", description = "用户管理 -> 修改用户")
    @RequestMapping(value = "/v1/system/user/update")
    public BaseResult<String> updateUser(@RequestBody UserEntity user){
        userService.update(user);
        return returnSucceed(null);
    }

    @Log(logType = "操作日志", module = "系统管理", description = "用户管理 -> 密码重置")
    @RequestMapping(value = "v1/system/user/pwdReset")
    public BaseResult<Object> resetPwd(@RequestBody List<String> sids){
        if (sids == null || sids.isEmpty()) {
            throw new ControllerException(UserErrorCodeEnum.E22011, UserErrorCodeEnum.E22011.getText());
        }
        userService.resetPwd(sids);
        return returnSucceed(null);
    }
}

package com.lcms.modules.system.user.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.common.domain.entity.BaseResult;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.log.annotation.Log;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 查询用户")
    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/v1/system/user/queryUsers")
    public BaseResult<Object> queryUsers(UserEntity user){
        IPage<UserEntity> userEntityIPage = userService.queryUsers(user);
        return returnSucceed(userEntityIPage.getRecords(),userEntityIPage.getTotal());
    }

    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 删除用户")
    @RequestMapping(value = "/v1/system/user/delete")
    public BaseResult<Object> delete(Long id){
        userService.delete(id);
       return returnSucceed(null);
    }
    
    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 添加用户")
    @RequestMapping(value = "/v1/system/user/insert")
    public void insertUser(UserEntity user){
    	userService.insertUser(user);
    }

    @Log(logType = "1", module = "用户管理", description = "用户管理 -> 修改用户")
    @RequestMapping(value = "/v1/system/user/update")
    public void updateUser(UserEntity user){
    	userService.updateByPrimaryKey(user);
    }
}

package com.lcms.modules.system.user.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.common.domain.entity.BaseResult;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/v1/system/user/queryUsers")
    public BaseResult<Object> queryUsers(BaseVo baseVo){
        IPage<UserEntity> userEntityIPage = userService.queryUsers(baseVo);
        return returnSucceed(userEntityIPage.getRecords(),userEntityIPage.getTotal());
    }

    @RequestMapping(value = "/v1/system/user/delete")
    public BaseResult<Object> delete(String id){
//        userService.delete(id);
       return returnSucceed(null);
    }
}

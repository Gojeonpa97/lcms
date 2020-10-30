package com.lcms.modules.system.log.web;

import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.exception.ControllerException;
import com.lcms.common.log.annotation.Log;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.log.domain.dto.SysLogDto;
import com.lcms.modules.system.log.domain.entity.SysLog;
import com.lcms.modules.system.log.domain.enums.LogErrorCode;
import com.lcms.modules.system.log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/v1/system/log/queryLogs",method = RequestMethod.GET)
    @Log(logType = "操作日志", module = "系统管理", description = "日志管理 -> 日志查询")
    public BaseResult<Object> queryLog(SysLogDto sysLog){
        BasePageDto<SysLog> sysLogIPage = sysLogService.queryLogs(sysLog);
        return  returnSucceed(sysLogIPage);
    }

    @RequestMapping(value = "/v1/system/log/deleteLog")
    @Log(logType = "操作日志", module = "系统管理", description = "日志管理 -> 日志删除")
    public BaseResult<String> deleteLog(@RequestBody List<String> ids){
        if(ids == null || ids.size() == 0){
            throw new ControllerException(LogErrorCode.E22402,LogErrorCode.E22402.getText());
        }
        sysLogService.delete(ids);
        return returnSucceed(null);
    }
}

package com.lcms.modules.system.log.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcms.common.domain.dto.BaseResult;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.common.web.BaseController;
import com.lcms.modules.system.log.domain.entity.SysLog;
import com.lcms.modules.system.log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/v1/system/log/queryLogs")
    public BaseResult<Object> queryLog(SysLog sysLog, BaseVo baseVo){
        IPage<SysLog> sysLogIPage = sysLogService.queryLogs(sysLog,baseVo);
        return  returnSucceed(sysLogIPage.getRecords(),sysLogIPage.getTotal());
    }

    @RequestMapping(value = "/v1/system/log/deleteLog")
    public void deleteLog(List<String> ids){
        if(ids == null || ids.size() == 0){

        }
        sysLogService.delete(ids);
    }
}

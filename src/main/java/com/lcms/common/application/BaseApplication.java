package com.lcms.common.application;

import com.lcms.common.domain.dto.BasePageDto;

import java.util.List;

public class BaseApplication {

    /**
     * 基础查询分页返回参数
     * @author
     * @date
     * @param
     * @return
     */
    public <T> BasePageDto<T> returnBaseResult(List<T> list, long total) {
        BasePageDto<T> basePageResult = new BasePageDto<T>();
        basePageResult.setRecords(list);
        basePageResult.setTotal(total);
        return basePageResult;
    }

    /**
     * 基础查询分页返回参数
     * @author
     * @date
     * @param
     * @return
     */
    public <T> BasePageDto<T> returnBaseResult(List<T> list, long total, long pageNum, long pages) {
        BasePageDto<T> basePageResult = new BasePageDto<T>();
        basePageResult.setRecords(list);
        basePageResult.setTotal(total);
        basePageResult.setPageNum(pageNum);
        basePageResult.setPages(pages);
        return basePageResult;
    }

}

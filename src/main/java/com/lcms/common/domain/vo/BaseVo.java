package com.lcms.common.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseVo {

    /**
     * 当前页数
     */

    private long pageSize;
    /**
     * 每页条数
     */

    private long pageNum;
}

package com.lcms.common.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseVo {

    /**
     * 当前页数
     */
	@TableField(select=false)
    private long pageSize;
    /**
     * 每页条数
     */
	@TableField(select=false)
    private long pageNum;
}

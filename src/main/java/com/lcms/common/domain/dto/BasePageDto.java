package com.lcms.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("rawtypes")
@JsonIgnoreProperties(value = {"handler"})
public class BasePageDto<T> implements Serializable {

    private static final long serialVersionUID = 5026411764606241146L;

    /**
     * 总条数
     */
    private long total;

    /**
     * 分页结果集
     */
    private List records;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 当前页数页数
     */
    private long pageNum;


    public BasePageDto() {

    }

    public BasePageDto(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public BasePageDto(long total, List<T> records, long pages, long pageNum) {
        this.total = total;
        this.records = records;
        this.pages = pages;
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }
}

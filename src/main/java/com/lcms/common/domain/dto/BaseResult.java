package com.lcms.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcms.common.domain.IEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"handler"})
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -7332240831887393753L;
    /**
     * 执行结果 成功/失败
     */
    private boolean success;

    /**
     * 状态码
     */
    private String code;

    /**
     * 错误编码
     */
    private IEnum errorCode;
    /**
     * 错误消息
     */
    private String errorMessage;
    // 可用于返回的实例
    /**
     * 返回数据
     */
    private T data;
    /**
     * 成功
     */
    private String successMessage;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
        return json;
    }
}

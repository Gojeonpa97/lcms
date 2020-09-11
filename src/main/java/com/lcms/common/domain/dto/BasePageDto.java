package com.lcms.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"handler"})
public class BasePageDto<T> implements Serializable {

    private static final long serialVersionUID = 5026411764606241146L;
}

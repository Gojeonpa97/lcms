package com.lcms.modules.system.log.domain.enums;

import com.lcms.common.domain.IEnum;
import com.lcms.modules.system.user.domain.enums.UserErrorCodeEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public enum LogErrorCode implements IEnum {

    E22401("22401", "参数不能为空！"),
    E22402("22402", "SID不能为空！"),
    E22403("22403", "请选择数据！"),;

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

    private String value;

    private String text;

    static {
        for (LogErrorCode em : LogErrorCode.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    /**
     * @param value
     * @param text
     */
    LogErrorCode(final String value, final String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }

    public static LogErrorCode get(String enumValue) {
        for (LogErrorCode em : LogErrorCode.values()) {
            if (em.getValue().equals(enumValue)) {
                return em;
            }
        }
        throw new IllegalArgumentException("不包含此枚举值.");
    }

    public static Map<String, String> mapping() {
        return MAPPING;
    }

    public static Map<String, String> inverseMapping() {
        return INVERSE_MAPPING;
    }
}

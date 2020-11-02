package com.lcms.modules.system.user.domain.enums;

import com.lcms.common.domain.IEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public enum SystemErrorCode implements IEnum {

    E22011("22011", "请选择数据！"),
    /**
     * 角色错误代码
     */
    E23001("23001", "资源的SID不能空！"),
    E23005("23005", "角色不存在！"),;

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

    private String value;

    private String text;

    static {
        for (SystemErrorCode em : SystemErrorCode.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    /**
     * @param value
     * @param text
     */
    SystemErrorCode(final String value, final String text) {
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

    public static SystemErrorCode get(String enumValue) {
        for (SystemErrorCode em : SystemErrorCode.values()) {
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

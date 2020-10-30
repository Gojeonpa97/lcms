package com.lcms.modules.system.user.domain.enums;

import com.lcms.common.domain.IEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public enum UserErrorCodeEnum implements IEnum {

    E22000("22000", "用户不存在或已经被删除！"),
    E22006("22006", "用户账号已存在！"),
    E22011("22011", "请选择数据！"),;

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

    private String value;

    private String text;

    static {
        for (UserErrorCodeEnum em : UserErrorCodeEnum.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    /**
     * @param value
     * @param text
     */
    UserErrorCodeEnum(final String value, final String text) {
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

    public static UserErrorCodeEnum get(String enumValue) {
        for (UserErrorCodeEnum em : UserErrorCodeEnum.values()) {
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

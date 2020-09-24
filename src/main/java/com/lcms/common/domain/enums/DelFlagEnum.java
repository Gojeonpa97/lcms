package com.lcms.common.domain.enums;

import com.lcms.common.domain.IEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public enum DelFlagEnum implements IEnum {

    DELETE("1", "删除"),

    CREATE("0", "创建");

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

    private String value;

    private String text;

    static {
        for (DelFlagEnum em : DelFlagEnum.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    /**
     * @param value
     * @param text
     */
    DelFlagEnum(final String value, final String text) {
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

    public static DelFlagEnum get(String enumValue) {
        for (DelFlagEnum em : DelFlagEnum.values()) {
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

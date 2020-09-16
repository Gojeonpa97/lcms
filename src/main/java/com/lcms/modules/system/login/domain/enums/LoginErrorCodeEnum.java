package com.lcms.modules.system.login.domain.enums;

import com.lcms.common.domain.IEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public enum LoginErrorCodeEnum implements IEnum {

    E10201("10201", "没有权限"),
    E10202("10202", "用户名或密码错误"),
    E10203("10203", "账户已被锁定，请10分钟后重试"),
    E10204("10204", "设备不存在，无权登录"),
    E10205("10205", "用户机构不存在"),
    E10206("10206", "用户登录PRIVATETOKEN失效,请重新登陆"),
    E10207("10207", "用户登陆PRIVATETOKEN无效"),
    E10208("10208", "验证码错误");

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String,String> INVERSE_MAPPING = new LinkedHashMap<String,String>();

    private String value;

    private String text;

    static {
        for (LoginErrorCodeEnum em : LoginErrorCodeEnum.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    /**
     *
     * @param value
     * @param text
     */
    LoginErrorCodeEnum(final String value, final String text) {
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

    public static LoginErrorCodeEnum get(String enumValue) {
        for (LoginErrorCodeEnum em : LoginErrorCodeEnum.values()) {
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

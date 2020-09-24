package com.lcms.common.mybatis.utils;

import com.lcms.common.domain.IEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * 自定义mybatis枚举转换器
 * @param <E>
 */
public class ValuedEnumTypeHandler <E extends IEnum> extends BaseTypeHandler<E> {

    private Class<E> type;
    private Map<Object, E> map = new HashMap<Object, E>();

    public ValuedEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        // 防止java.lang.Object被拦截
        if (!type.getSimpleName().equals("Object")) {
            E[] enums = type.getEnumConstants();
            if (enums == null) {
                throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enums type.");
            }

            for (E e : enums) {
                IEnum valuedEnum = (IEnum) e;
                try {
                    map.put(valuedEnum.getValue(), e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        IEnum valuedEnum = (IEnum) parameter;
        Object value = valuedEnum.getValue();
        if (value instanceof Integer) {
            Integer tmp = value == null ? 0 : Integer.parseInt(value.toString());
            ps.setInt(i, tmp);
        } else {
            ps.setString(i, value.toString());
        }

    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object obj = rs.getObject(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(obj);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object obj = rs.getObject(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(obj);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object obj = cs.getObject(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(obj);
        }
    }

    private E getValuedEnum(Object value) {
        try {
            if (value instanceof BigDecimal) {
                value = Integer.parseInt(value.toString());
            }
            return map.get(value);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot convert " + value + " to " + type.getSimpleName() + " by value.", ex);
        }
    }
}

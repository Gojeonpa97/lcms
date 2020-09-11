package com.lcms.common.log.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface Log {

    /**
     * 日志类别
     */
    String logType() default "";

    /**模块*/
    String module() default "";

    /**描述*/
    String description() default "";
}

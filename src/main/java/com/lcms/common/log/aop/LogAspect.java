package com.lcms.common.log.aop;

import com.lcms.common.log.annotation.Log;
import com.lcms.modules.system.log.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面处理类
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 保存系统操作日志
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     * @throws Throwable 调用出错
     */
    @Around(value = "execution(* com.lcms.modules.*.*.web.*.*(..)) && @annotation(com.lcms.common.log.annotation.Log)")
    public Object save(ProceedingJoinPoint joinPoint) throws Throwable {

        /**
         * 解析Log注解
         */
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint, methodName);
        Log log = method.getAnnotation(Log.class);
        System.out.println(log);
        /**
         * 日志入库
         */
        if (log != null) {
            sysLogService.save(joinPoint,methodName,log.logType(),log.module(),log.description());
        }

        /**
         * 方法执行
         */
        return joinPoint.proceed();
    }
    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(ProceedingJoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }
}

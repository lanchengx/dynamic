package com.example.dynamic.aop;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @Author: lanchengx
 * @Date: 2020/5/10 0010
 */
@Aspect
@Component
@Order(0)
@Lazy(false)
@Log
public class DataSourceAop {

    private static final String MASTER = "master";

    private static final String SLAVE = "slave";

    @Pointcut(" execution(* com.example.dynamic.service..*.*(..)) " +
            "|| execution(* com.baomidou.mybatisplus.extension.service..*.*(..)) " +
            "|| @annotation(org.springframework.transaction.annotation.Transactional)")
    public void checkArgs() {
    }

    // 这里切到你的方法目录
    @Before("checkArgs()")
    public void process(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {
        String methodName = joinPoint.getSignature().getName();
        Class clazz = joinPoint.getTarget().getClass();
        if (clazz.isAnnotationPresent(DS.class)) {
            //获取类上注解
            return;
        }
        if (clazz.isAnnotationPresent(Transactional.class)) {
            log.info("当前执行的库：" + MASTER);
            DynamicDataSourceContextHolder.push(MASTER);
            return;
        }
        String targetName = clazz.getSimpleName();
        Class[] parameterTypes =
                ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        Method methdo = clazz.getMethod(methodName, parameterTypes);
        if (methdo.isAnnotationPresent(DS.class)) {
            return;
        }
        if (methdo.isAnnotationPresent(Transactional.class)) {
            log.info("当前执行的库：" + MASTER);
            DynamicDataSourceContextHolder.push(MASTER);
            return;
        }
        if (methodName.startsWith("get")
                || methodName.startsWith("count")
                || methodName.startsWith("find")
                || methodName.startsWith("list")
                || methodName.startsWith("select")
                || methodName.startsWith("check")
                || methodName.startsWith("page")) {

            log.info("当前执行的库：" + SLAVE);
            DynamicDataSourceContextHolder.push(SLAVE);
        } else {
            log.info("当前执行的库：" + MASTER);
            DynamicDataSourceContextHolder.push(MASTER);
        }
    }

    @After("checkArgs()")
    public void afterAdvice() {
        DynamicDataSourceContextHolder.clear();
    }

}

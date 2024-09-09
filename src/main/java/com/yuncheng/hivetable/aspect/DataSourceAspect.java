package com.yuncheng.hivetable.aspect;

import com.yuncheng.hivetable.annotion.DataSource;
import com.yuncheng.hivetable.config.DatabaseContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect implements Ordered {
    /**
     * 指定切入点
     */
    @Pointcut("@annotation(com.yuncheng.hivetable.annotion.DataSource)")
    public void dataSourcePointCut(){

    }

    @After("dataSourcePointCut()")
    public void after(){
        DatabaseContextHolder.clearDataSource();
    }
    /**
     * 环绕通知，包含了五种通知类型
     * @return
     */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method=signature.getMethod();
        //默认数据源
        String defaultDataSource= DatabaseContextHolder.FIRST_DS;
        //获取该注解
        DataSource dataSource=method.getAnnotation(DataSource.class);
        //存在注解，直接切换该注解对应的数据源
//        System.out.println("dataSource.value()  " + dataSource.value());
        if(dataSource != null){
            defaultDataSource=dataSource.value();
        }
        //切换数据源
        DatabaseContextHolder.setDataBase(defaultDataSource);
        //继续执行方法
        Object result=null;
        try {
            result=point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //最后清除数据源
            DatabaseContextHolder.clearDataSource();
        }
        return result;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
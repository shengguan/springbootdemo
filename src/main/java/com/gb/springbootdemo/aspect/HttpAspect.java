package com.gb.springbootdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.gb.springbootdemo.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //获取请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取IP
        logger.info("IP = {}" , request.getRemoteAddr());
        //获取方法
        logger.info("method = {}" , request.getMethod());
        //获取请求地址
        logger.info("url = {}" ,request.getRequestURL());
        //获取请求方法
        logger.info("class_method={}" ,joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取参数
        logger.info("args={}" ,joinPoint.getArgs());

    }
    @After("log()")
    public void doAfter(){
        logger.info("22222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info(object.toString());
    }

}

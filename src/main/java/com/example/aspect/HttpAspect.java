package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/3
 * Time: 下午10:17
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.controller.GirlController.getGirls(..))")
    public void log() {
    }

    @Before("log())")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        LOGGER.info("get girls before...");
        HttpServletRequest request = requestAttributes.getRequest();
        //url
        LOGGER.info("url:{}" ,request.getRequestURL() );
        //ip
        LOGGER.info("ip:{}",request.getRemoteAddr());
        //method
        LOGGER.info("method:{}" ,joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        //args
        LOGGER.info("args:{}",joinPoint.getArgs());
    }
    @After("log())")
    public void doAfter() {
        LOGGER.info("get girls after");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        LOGGER.info("return:{}",object);
    }

}

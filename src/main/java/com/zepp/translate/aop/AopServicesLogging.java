package com.zepp.translate.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class AopServicesLogging {
    @Before("com.zepp.translate.aop.AopExpressions.forDeleteInServices()")
    public void beforeDeleteMethodsInServices(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.toString());
        Object[] args = joinPoint.getArgs();
        for(Object o: args){
            log.info(o.toString());
        }
    }

    @AfterReturning("com.zepp.translate.aop.AopExpressions.forSaveInServices()")
    public void aroundSaveMethods(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.toString());
        Object[] args = joinPoint.getArgs();
        for(Object o: args){
            log.info(o.toString());
        }
    }

    @AfterThrowing(pointcut = "execution(* com.zepp.translate.*.*(..))", throwing = "exc")
    public void afterThrow(JoinPoint joinPoint, Throwable exc) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.toString());
        log.error(exc.toString());
        System.out.println("ERROR aop");
        log.info("\n=====>>> The exception is: " + exc);
    }
}

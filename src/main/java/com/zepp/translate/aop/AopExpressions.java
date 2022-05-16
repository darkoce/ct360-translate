package com.zepp.translate.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.zepp.translate.services.*.*elete*(..))")
    protected void forDeleteInServices(){};

    @Pointcut("execution(* com.zepp.translate.services.*.save*(..))")
    protected void forSaveInServices(){};
}

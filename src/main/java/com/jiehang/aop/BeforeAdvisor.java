package com.jiehang.aop;

import java.lang.reflect.Method;

public class BeforeAdvisor extends AbstractAdvisor {

    public BeforeAdvisor(Object aopObj, Method aopMethod) {
        super(aopObj, aopMethod);
        setOrder(1);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = {methodInvocation.getArguments()};//将Object[]转为数组，不然报错
        aopMethod.invoke(aopObj, args);
        return methodInvocation.proceed();
    }

}
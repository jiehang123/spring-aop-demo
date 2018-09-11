package com.jiehang.aop;

import java.lang.reflect.Method;

public class AfterAdvisor extends AbstractAdvisor {
    public AfterAdvisor(Object aopObj, Method aopMethod) {
        super(aopObj, aopMethod);
        setOrder(2);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = methodInvocation.proceed();
        Object[] args = {methodInvocation.getArguments()};//将Object[]转为数组，不然报错
        aopMethod.invoke(aopObj, args);
        return result;
    }
}
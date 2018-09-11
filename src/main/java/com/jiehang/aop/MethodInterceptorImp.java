package com.jiehang.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MethodInterceptorImp implements MethodInterceptor {

    private Map<Method, List<Advisor>> methodListMap;

    public MethodInterceptorImp(Map<Method, List<Advisor>> methodListMap) {
        this.methodListMap = methodListMap;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        List<Advisor> advisors = methodListMap.get(method);

        if (advisors == null){
            return proxy.invokeSuper(obj, args);
        }

        Collections.sort(advisors, new Comparator<Advisor>() {
            @Override
            public int compare(Advisor o1, Advisor o2) {
                return o2.getOrder() - o1.getOrder();
            }
        });

        MethodInvocation methodInvocation = new MethodInvocation(obj, method, args, proxy, advisors);

        return methodInvocation.proceed();
    }
}
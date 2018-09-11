package com.jiehang.aop;

import java.lang.reflect.Method;

public interface Advisor extends MethodInterceptor, Orderable {

    boolean isMatch(Class<?> clazz, Method method);
}
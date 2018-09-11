package com.jiehang.aop;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.regex.Pattern;

public abstract class AbstractAdvisor implements Advisor {

    protected int order = 0;

    protected Pattern pattern;

    protected Object aopObj;

    protected Method aopMethod;

    public AbstractAdvisor(Object aopObj, Method aopMethod) {
        this.aopObj = aopObj;
        this.aopMethod = aopMethod;

        String reg = aopObj.getClass().getAnnotation(MyAspect.class).pointCut();
        this.pattern = Pattern.compile(reg);
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean isMatch(Class<?> clazz, Method method) {
        return pattern.matcher(clazz.getName() + "." + method.getName()).find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAdvisor that = (AbstractAdvisor) o;
        return Objects.equals(aopObj, that.aopObj) &&
                Objects.equals(aopMethod, that.aopMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aopObj, aopMethod);
    }
}
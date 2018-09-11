package com.jiehang.aop;

import net.sf.cglib.proxy.Enhancer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MyAspectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private List<Advisor> cacheAdvisors;//缓存提升性能

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        buildAdvisors();//构建增强

        Map<Method, List<Advisor>> methodListMap = getMatchAdvisor(bean);
        if (methodListMap.isEmpty())
            return bean;

        Enhancer enhancer = new Enhancer();//创建代理
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new MethodInterceptorImp(methodListMap));
        return enhancer.create();
    }

    private void buildAdvisors() {
        if (cacheAdvisors != null) {
            return;
        }

        if (cacheAdvisors == null) {
            cacheAdvisors = new ArrayList<>();
        }

        Map<String, Object> map = applicationContext.getBeansWithAnnotation(MyAspect.class);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object aopObj = entry.getValue();
            Method[] methods = aopObj.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().equals("before")) {
                    Advisor advisor = new BeforeAdvisor(aopObj, method);
                    if (!cacheAdvisors.contains(advisor))
                        cacheAdvisors.add(advisor);
                } else if (method.getName().equals("after")) {
                    Advisor advisor = new AfterAdvisor(aopObj, method);
                    if (!cacheAdvisors.contains(advisor))
                        cacheAdvisors.add(advisor);
                }
            }

        }

    }

    private Map<Method, List<Advisor>> getMatchAdvisor(Object bean) {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getMethods();

        Map<Method, List<Advisor>> methodListMap = new HashMap<>();
        for (Method method : methods) {
            for (Advisor advisor : cacheAdvisors) {
                if (advisor.isMatch(clazz, method)) {
                    List<Advisor> advisors = methodListMap.get(method);
                    if (advisors == null) {
                        advisors = new ArrayList<>();
                        methodListMap.put(method, advisors);
                    }

                    advisors.add(advisor);
                }
            }

        }

        return methodListMap;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
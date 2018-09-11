package com.jiehang.aop.test;

import com.jiehang.aop.BarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyAspect {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BarService service = context.getBean(BarService.class);
        service.doSomething();
    }
}

package com.jiehang.aop;

import org.springframework.stereotype.Service;

@Service
public class BarServiceImp implements BarService {
    @Override
    public void doSomething() {
        System.out.println("执行原有业务逻辑...");
    }
}
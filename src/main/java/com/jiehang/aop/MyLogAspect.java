package com.jiehang.aop;

@MyAspect(pointCut = "com.jiehang.aop.BarServiceImp.doSomething")
public class MyLogAspect {
    public void before(Object[] args) {
//        System.out.println("before增强，args[0]:" + args[0] + ", args[1]:" + args[1]);
        System.out.println("before增强");

    }

    public void after(Object[] args) {
//        System.out.println("after增强，args[0]:" + args[0] + ", args[1]:" + args[1]);
        System.out.println("after增强");
    }

}
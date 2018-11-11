package com.jiehang;

import org.springframework.stereotype.Component;

@Component("testBean")
public class TestBean {

    public void test(String string) {
        System.out.println("TestBean.test()" + string);
    }


}

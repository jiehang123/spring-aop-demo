package com.jiehang.activemq;

public class Test {

    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MAX_VALUE - 2;

    public static void main(String[] args) {
        int count = 0;
        for (int i = MIN; i < MAX; i++) {
            count++;
            System.out.println(i);
        }
        System.out.println(count);
    }

}

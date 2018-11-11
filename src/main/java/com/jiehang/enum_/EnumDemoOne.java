package com.jiehang.enum_;

public class EnumDemoOne {
    private enum InnerEnum {
        RED, GREEN, YELLOW
    }

    ;

    public static void main(String[] args) {
        System.out.println(InnerEnum.RED.toString());
        System.out.println(InnerEnum.GREEN);
        System.out.println(InnerEnum.YELLOW);
    }
} 
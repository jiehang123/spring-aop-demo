package com.jiehang.enum_;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumDemoThree {

    // 1. 定义枚举类型
    public enum Light {
        /*利用构造函数传参利用构造函数传参
         * 通过括号赋值,而且必须有带参构造器和属性和方法，否则编译出错
         * 赋值必须是都赋值或都不赋值，不能一部分赋值一部分不赋值
         * 如果不赋值则不能写构造器，赋值编译也出错
         * */
        RED("红色"), GREEN("绿色"), YELLOW("黄色");

        // 定义私有变量
        private String clor;

        // 构造函数，枚举类型只能为私有
        private Light(String clor) {
            this.clor = clor;
        }

        public String getClor() {
            return this.clor;
        }

        public void setClor(String clor) {
            this.clor = clor;
        }

        @Override
        public String toString() {
            return "toString" + this.clor;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1. 遍历枚举类型
        System.out.println(" 演示枚举类型的遍历 ......");
        testTraversalEnum();
        // 2. 演示 EnumMap 对象的使用
        System.out.println(" 演示 EnmuMap 对象的使用和遍历 .....");
        testEnumMap();
        // 3. 演示 EnmuSet 的使用
        System.out.println(" 演示 EnmuSet 对象的使用和遍历 .....");
        testEnumSet();
    }

    /**
     * 演示枚举类型的遍历
     */
    private static void testTraversalEnum() {
        Light[] allLight = Light.values();
        for (Light aLight : allLight) {
            System.out.println(" 当前灯 name ： " + aLight.name());
            System.out.println(" 当前灯 ordinal ： " + aLight.ordinal());
            System.out.println(" 当前灯： " + aLight);
        }
    }

    /**
     * 演示 EnumMap 的使用， EnumMap 跟 HashMap 的使用差不多，只不过 key 要是枚举类型
     */
    private static void testEnumMap() {
        // 1. 演示定义 EnumMap 对象， EnumMap 对象的构造函数需要参数传入 , 默认是 key 的类的类型
        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(
                Light.class);
        currEnumMap.put(Light.RED, " 红灯 ");
        currEnumMap.put(Light.GREEN, " 绿灯 ");
        currEnumMap.put(Light.YELLOW, " 黄灯 ");

        // 2. 遍历对象
        for (Light aLight : Light.values()) {
            System.out.println("[key=" + aLight.name() + ",value="
                    + currEnumMap.get(aLight) + "]");
        }
    }

    /**
     * 演示 EnumSet 如何使用， EnumSet 是一个抽象类，获取一个类型的枚举类型内容 <BR/>
     * 可以使用 allOf 方法
     */
    private static void testEnumSet() {
        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
        for (Light aLightSetElement : currEnumSet) {
            System.out.println(" 当前 EnumSet 中数据为： " + aLightSetElement);
        }
    }
}

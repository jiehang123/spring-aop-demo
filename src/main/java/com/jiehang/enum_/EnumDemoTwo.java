package com.jiehang.enum_;

public class EnumDemoTwo {
    public enum ColorSelect {
        red, green, yellow, blue;
    }

    public static void main(String[] args) {
        /*
         * 枚举类型是一种类型，用于定义变量，以限制变量的赋值 赋值时通过"枚举名.值"来取得相关枚举中的值
         */
        ColorSelect m = ColorSelect.blue;
        switch (m) {
            /*注意:枚举重写了ToString(),说以枚举变量的值是不带前缀的
             * 所以为blue而非ColorSelect.blue
             */
            case red:
                System.out.println("color is red");
                break;
            case green:
                System.out.println("color is green");
                break;
            case yellow:
                System.out.println("color is yellow");
                break;
            case blue:
                System.out.println("color is blue");
                break;
        }
        System.out.println("遍历ColorSelect中的值");
        /*通过values()获得枚举值的数组*/
        for (ColorSelect c : ColorSelect.values()) {
            System.out.println(c);
        }
        System.out.println("枚举ColorSelect中的值有：" + ColorSelect.values().length + "个");
        /*ordinal()返回枚举值在枚举中的索引位置，从0开始*/
        System.out.println(ColorSelect.red.ordinal());//0
        System.out.println(ColorSelect.green.ordinal());//1
        /*name()返回枚举值在枚举中的名称*/
        System.out.println(ColorSelect.yellow.name());//yellow
        System.out.println(ColorSelect.blue.name());//blue
        /*枚举默认实现了java.lang.Comparable接口,-1之前，0位置相同，1之后*/
        System.out.println(ColorSelect.red.compareTo(ColorSelect.green));
        /*静态valueOf()方法可以让您将指定的字符串尝试转换为枚举类型*/
        ColorSelect red = ColorSelect.valueOf("red");
        System.out.println(red);
        System.out.println(red.getClass());
    }
}  
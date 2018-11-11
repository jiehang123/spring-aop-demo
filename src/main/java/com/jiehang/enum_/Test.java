package com.jiehang.enum_;

public class Test {

    private enum TestEnum {
        AAA("aa"), BBB("bb"), CCC("cc");

        private String string;

        TestEnum(String s) {
            this.string = s;
        }

        @Override
        public String toString() {
            return "TestEnum{" +
                    "string='" + string + '\'' +
                    '}';
        }
    };

    public static void main(String[] args) {
        System.out.println(TestEnum.AAA.name());
        System.out.println(TestEnum.BBB.ordinal());
        System.out.println(TestEnum.BBB.toString());
        System.out.println(TestEnum.CCC);
        System.out.println(TestEnum.CCC.getDeclaringClass());
    }


}

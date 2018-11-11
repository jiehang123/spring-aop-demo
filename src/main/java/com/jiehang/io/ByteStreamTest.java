package com.jiehang.io;

import java.io.*;

public class ByteStreamTest {
    public static void main(String args[]) throws IOException {
//        testByteArrayOutputStream();
    }

    public static void test1() {
        int a = 1;
        int b = 1;
        int c = 2;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(a);
        bout.write(b);
        bout.write(c);
        byte[] buff = bout.toByteArray();
        for (int i = 0; i < buff.length; i++)
            System.out.println(buff[i]);
        System.out.println("***********************");
        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        while ((b = bin.read()) != -1) {
            System.out.println(b);
        }

    }

    public static void testByteArrayOutputStream() throws IOException {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

        while (bOutput.size() != 10) {
            // 获取用户输入值
            bOutput.write(System.in.read());
        }

        byte b[] = bOutput.toByteArray();
        System.out.println("Print the content");
        for (int x = 0; x < b.length; x++) {
            // 打印字符
            System.out.print((char) b[x] + "   ");
        }
        System.out.println("   ");

        int c;

        ByteArrayInputStream bInput = new ByteArrayInputStream(b);

        System.out.println("Converting characters to Upper case ");
        for (int y = 0; y < 1; y++) {
            while ((c = bInput.read()) != -1) {
                System.out.println(Character.toUpperCase((char) c));
            }
            bInput.reset();
        }
    }
}

package com.jiehang.io;

import java.io.*;

public class IoClientTest {
    public static void main(String[] args) throws Exception{
        //            testInputStreamReader();
//        testFileReader();
//            deepCopy(new Object());
        testByteArrayInputStream();
    }


    /**
     * 使用FileReader读取文件内容
     */
    public static void testFileReader() throws IOException {
        File file = new File("C:\\Users\\jiehang\\Desktop\\test.sql");
        StringBuffer stringBuffer = new StringBuffer();
        Reader fileReader = null;
        fileReader = new FileReader(file);
        char[] c = new char[1024];
        int len;
        while ((len = fileReader.read(c)) != -1) {
            stringBuffer.append(c, 0, len);
        }
        System.out.println(stringBuffer.toString());
        fileReader.close();
    }

    /**
     * 使用InputStreamReader读取文件内容
     */
    public static void testInputStreamReader() throws IOException {
        File file = new File("C:\\Users\\jiehang\\Desktop\\test.sql");
        StringBuffer stringBuffer = new StringBuffer();
        Reader inputStreadReader = new InputStreamReader(new FileInputStream(file));
        char[] c = new char[1024];
        int len;
        while ((len = inputStreadReader.read(c)) != -1) {
            stringBuffer.append(c, 0, len);
        }
        System.out.println(stringBuffer.toString());
        inputStreadReader.close();
    }

    public static void testByteArrayInputStream() {
        int a = 0;
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

    /**
     * 使用 ObjectInputStream和ObjectOutputStream实现 DeepCopy
     *
     * @param from
     * @return
     */
    public static Object deepCopy(Object from) throws IOException, ClassNotFoundException {
        Object obj = null;
        // 将对象写成 Byte Array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        //将指定的对象写入 ObjectOutputStream。
        out.writeObject(from);
        out.flush();
        out.close();

        // 从流中读出 byte array，调用readObject函数反序列化出对象
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        // 从 ObjectInputStream 读取对象。
        obj = in.readObject();
        return obj;
    }

}

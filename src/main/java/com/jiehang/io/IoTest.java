package com.jiehang.io;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.io.*;

public class IoTest {

    public static void main(String[] args) {

//        try {
//            InputStream inputStream = new FileInputStream("C:\\Users\\jiehang\\Desktop\\IO.jpg");
//            OutputStream outputStream = new FileOutputStream("C:\\Users\\jiehang\\Desktop\\IO88.png");
//            byte[] b = new byte[1024];
//            while (inputStream.read(b) != -1) {
//                outputStream.write(b);
//            }
//
//            inputStream.close();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            Reader reader = new StringReader("博客\n" +
                    "学院\n" +
                    "下载\n" +
                    "图文课\n" +
                    "TinyMind\n" +
                    "论坛\n" +
                    "APP\n" +
                    "问答\n" +
                    "商城\n" +
                    "VIP会员\n" +
                    "活动\n" +
                    "招聘\n" +
                    "ITeye\n" +
                    "GitChat\n" +
                    "\n" +
                    "搜博主文章\n" +
                    "写博客\n" +
                    "发Chat\n" +
                    "传资源\n" +
                    "登录注册\n" +
                    "转\n" +
                    "JAVA提高篇（22）--StringReader和StringWriter的用法\n" +
                    "2017年10月08日 09:23:40 白面小书生 阅读数：485更多\n" +
                    "个人分类： Java高级学习笔记\n" +
                    "使用字符串作为物理节点的字符输入输出流的用法，即StringReader和StringWriter的用法\n" +
                    "\n" +
                    "[java] view plain copy\n" +
                    "package net.nyist.io;  \n" +
                    "  \n" +
                    "import java.io.IOException;  \n" +
                    "import java.io.StringReader;  \n" +
                    "import java.io.StringWriter;  \n" +
                    "  \n" +
                    "public class StringNodeTest {  \n" +
                    "  \n" +
                    "    public static void main(String[] args) {  \n" +
                    "  \n" +
                    "        String src = \"从明天起，做一个幸福的人，\\n喂马，劈材，周游世界，\\n从明天起，关心粮食和蔬菜，\\n我有一所房子，面朝大海，春暖花开，\\n从明天起，和每一个人通信，告诉他们我的幸福\\n\";  \n" +
                    "  \n" +
                    "        char[] buffer = new char[32];  \n" +
                    "        int hasRead = 0;  \n" +
                    "          \n" +
                    "        try(  \n" +
                    "                StringReader sr = new StringReader(src);  \n" +
                    "                  \n" +
                    "                ){  \n" +
                    "            //采用循环读取的方式，读取字符串  \n" +
                    "            while((hasRead  = sr.read(buffer))> 0 ){  \n" +
                    "                //  \n" +
                    "                System.out.println(new String(buffer,0,hasRead));  \n" +
                    "            }  \n" +
                    "        }catch(IOException ioe){  \n" +
                    "              \n" +
                    "            ioe.printStackTrace();  \n" +
                    "        }  \n" +
                    "          \n" +
                    "        try(  \n" +
                    "                //  \n" +
                    "                StringWriter sw = new StringWriter();  \n" +
                    "                ){  \n" +
                    "            //调用方法执行输出  \n" +
                    "            sw.write(\"有一个美丽的新世界\\n\");  \n" +
                    "            sw.write(\"有一个美丽的新世界\\n\");  \n" +
                    "            sw.write(\"有一个美丽的新世界\\n\");  \n" +
                    "            sw.write(\"有一个美丽的新世界\\n\");  \n" +
                    "            sw.write(\"有一个美丽的新世界\\n\");  \n" +
                    "              \n" +
                    "            System.out.println(sw.toString());  \n" +
                    "              \n" +
                    "        }catch(IOException ioe){  \n" +
                    "              \n" +
                    "            ioe.printStackTrace();  \n" +
                    "              \n" +
                    "        }  \n" +
                    "          \n" +
                    "    }  \n" +
                    "  \n" +
                    "}  \n" +
                    "java IO笔记（StringReader/StringWriter）\n" +
                    "本篇将要讲述的是java io包中的StringReader和StringWriter。这两个类都是Reader和Writer的装饰类，使它们拥有了对String类型数据进行操作的能力。下面还是先附上...\n" +
                    "想对作者说点什么？ 我来说一句\n" +
                    "使用StringReader和StringWriter操作字符串\n" +
                    "zhaokai621\n" +
                    " 635\n" +
                    "\n" +
                    "编程举例：写一函数把StringReader中输入流中的字符串全部转换成大写，然后将结果写到一个StringWriter中，然后使用这一函数将以字符串全部转成大写。package cn.itcast....\n" +
                    "\n" +
                    "java中讲讲StringReader的用法，举例？\n" +
                    "mark_to_win\n" +
                    " 2488\n" +
                    "\n" +
                    "StringReader是Reader的继承类，从字面上就可看出，它是专门处理字符串的。 例：2.1.1 import java.io.*; public class TestMar...\n" +
                    "\n" +
                    " \n" +
                    "Java IO StringReader和StringWriter\n" +
                    "RichieZhu\n" +
                    " 2353\n" +
                    "\n" +
                    "StringReader类用来将字符串转换成字符输入流。然后使用字符输入流提供的方式进行操作，也可以提供给其他高级字符输入流来使用。如可以将该字符输入流提供给BufferedReader输入流使用。S...\n" +
                    "\n" +
                    "Java 7之传统I/O - 字符类 StringReader和StringWriter\n" +
                    "mazhimazh\n" +
                    " 7174\n" +
                    "\n" +
                    "这两个类将String类适配到了Reader和Writer接口，在StringWriter类实现的过程中，真正使用的是StringBuffer,前面讲过，StringBuffer是一个可变类，由于Wr...\n" +
                    "\n" +
                    "StringWriter 与StringReader 用法\n" +
                    "Susan8888\n" +
                    " 4065\n" +
                    "\n" +
                    "import java.io.IOException; import java.io.StringReader; import java.io.StringWriter; pub...\n" +
                    "\n" +
                    "StringWriter/PrintWriter在Java异常中的作用\n" +
                    "ITITII\n" +
                    " 167\n" +
                    "\n" +
                    "在Java中，利用try..catch（..finally）语句可以捕获和处理异常，非常方便。catch块的常见异常处理方式是输出异常，例如把异常输出到日志文件。 Exception类有一个prin...\n" +
                    "\n" +
                    "老中医说：男人多吃这个东西，时间延长五倍！\n" +
                    "精彩风机 · 燨燚\n" +
                    "? StringWriter\n" +
                    "PentaKillwusha\n" +
                    " 105\n" +
                    "\n" +
                    "public  class Fu {  public static void main(String[] args){   try(    StringWriter load=new StringWr...\n" +
                    "\n" +
                    "IO:使用字符串作为物理节点的字符输入输出流的用法，即StringReader和StringWriter的用法\n" +
                    "ma451152002\n" +
                    " 2.1万\n" +
                    "\n" +
                    "使用字符串作为物理节点的字符输入输出流的用法，即StringReader和StringWriter的用法 package net.nyist.io; import java.io.IOExce...\n" +
                    "\n" +
                    "JAVA基础知识之StringWriter流\n" +
                    "ai_bao_zi\n" +
                    " 30\n" +
                    "\n" +
                    "一、StringWriter流定义     API说明：在字符串缓冲区中收集输出的字符流，可用于构造字符串， 关闭流无效，关闭后调用其他方法不会报异常 二、StringWriter流实例域 ...\n" +
                    "\n" +
                    "个人资料\n" +
                    "\n" +
                    "白面小书生\n" +
                    "\n" +
                    "关注\n" +
                    "原创\n" +
                    "5\n" +
                    "粉丝\n" +
                    "27\n" +
                    "喜欢\n" +
                    "10\n" +
                    "评论\n" +
                    "6\n" +
                    "等级： 访问： 5万+ 积分： 819 排名： 7万+\n" +
                    "\n" +
                    "最新文章\n" +
                    "stm32 PB3 PB4 PA15引脚作为普通IO口使用指南\n" +
                    "定时器TIM和PWM的输出\n" +
                    "三极管开关电路图原理及设计详解\n" +
                    "STM32如何使用内部时钟源当系统时钟\n" +
                    "关于C++ const 的全面总结\n" +
                    "个人分类\n" +
                    "c语言6篇\n" +
                    "stm32学习笔记23篇\n" +
                    "安卓学习笔记1篇\n" +
                    "HDMI学习笔记23篇\n" +
                    "stm8学习笔记9篇\n" +
                    "Java学习笔记35篇\n" +
                    "Git1篇\n" +
                    "Java基础6篇\n" +
                    "Java高级学习笔记49篇\n" +
                    "MySQL学习笔记5篇\n" +
                    "展开\n" +
                    "\n" +
                    "归档\n" +
                    "2018年1月 1篇\n" +
                    "2017年12月 3篇\n" +
                    "2017年11月 4篇\n" +
                    "2017年10月 61篇\n" +
                    "2017年9月 54篇\n" +
                    "2017年8月 28篇\n" +
                    "2017年3月 1篇\n" +
                    "2016年2月 3篇\n" +
                    "2015年10月 1篇\n" +
                    "2015年6月 1篇\n" +
                    "2015年5月 2篇\n" +
                    "展开\n" +
                    "\n" +
                    "热门文章\n" +
                    "Java学习笔记(18)--关键字this详解\n" +
                    "阅读量：4962\n" +
                    "\n" +
                    "LCD(一)：LCD基本原理篇\n" +
                    "阅读量：3325\n" +
                    "\n" +
                    "STm32驱动74HC595引脚图时序图工作原理\n" +
                    "阅读量：2657\n" +
                    "\n" +
                    "STM32如何使用内部时钟源当系统时钟\n" +
                    "阅读量：2067\n" +
                    "\n" +
                    "如何获取程序编译时间\n" +
                    "阅读量：2049\n" +
                    "\n" +
                    "最新评论\n" +
                    "STm32驱动74HC595引脚图...\n" +
                    "huangyangquan：[reply]qq_39314918[/reply] 不是很单片机平时一样驱动啊\n" +
                    "\n" +
                    "STm32驱动74HC595引脚图...\n" +
                    "qq_39314918：74hc595怎么驱动数码管啊\n" +
                    "\n" +
                    "对寄存器操作的通用方法总结\n" +
                    "zhao_zilong：抄别人的文章，别人故意留有一个错误，难道自己写的会不清楚？？？？？？？？\n" +
                    "\n" +
                    "Stm 32 IAP 在线 升级I...\n" +
                    "qq_36674402：急需程序源码，麻烦博主给我发下 2250793351@qq.com\n" +
                    "\n" +
                    "HDMI之InfoFrame\n" +
                    "huangyangquan：6666666666666666666666666666\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "联系我们\n" +
                    "客服\n" +
                    "请扫描二维码联系客服\n" +
                    "webmaster@csdn.net\n" +
                    "\n" +
                    "400-660-0108\n" +
                    "\n" +
                    "QQ客服 客服论坛\n" +
                    "\n" +
                    "关于招聘广告服务 网站地图\n" +
                    "\n" +
                    "©2018 CSDN版权所有 京ICP证09002463号\n" +
                    "\n" +
                    "百度提供搜索支持\n" +
                    "\n" +
                    "app\n" +
                    "经营性网站备案信息\n" +
                    "\n" +
                    "网络110报警服务\n" +
                    "\n" +
                    "中国互联网举报中心\n" +
                    "\n" +
                    "北京互联网违法和不良信息举报中心\n" +
                    "\n" +
                    "CSDN APP\n" +
                    "\n" +
                    "\n" +
                    "登录\n" +
                    "注册\n" +
                    "\n" +
                    "\n" +
                    "0\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    " \n" +
                    "\n");
            Writer writer = new FileWriter("C:\\Users\\jiehang\\Desktop\\kkkk.txt");
            char[] c = new char[1024];
            int i;
            while ((i=reader.read(c)) != -1) {
                writer.write(c, 0, i);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

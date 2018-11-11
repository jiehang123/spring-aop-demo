package com.jiehang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+");

        Matcher m = p.matcher("aaa2223bb");
        System.out.println(m.find());//匹配2223
        System.out.println(m.start());//返回3
        System.out.println(m.end());//返回7,返回的是2223后的索引号
        System.out.println(m.group());//返回2223
        System.out.println("------");
        Matcher m2 = p.matcher("2223bb");
        System.out.println(m2.lookingAt());   //匹配2223
        System.out.println(m2.start());   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        System.out.println(m2.end());   //返回4
        System.out.println(m2.group());   //返回2223
        System.out.println("------");
        Matcher m3 = p.matcher("3453454");
        System.out.println(m3.matches());   //匹配整个字符串
        System.out.println(m3.start());   //返回0,原因相信大家也清楚了
        System.out.println(m3.end());   //返回7,原因相信大家也清楚了,因为matches()需要匹配所有字符串
        System.out.println(m3.group());   //返回3453454

        System.out.println("##############");
        Pattern pattern = Pattern.compile("([a-z]+)(\\d+)");
        Matcher matcher = pattern.matcher("aaa2223bb");
        System.out.println(matcher.find());//匹配aaa2223
        System.out.println(matcher.groupCount());   //返回2,因为有2组
        System.out.println(matcher.start(1));   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(matcher.start(2));   //返回3
        System.out.println(matcher.end(1));   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(matcher.end(2));   //返回7
        System.out.println(matcher.group(1));   //返回aaa,返回第一组匹配到的子字符串
        System.out.println(matcher.group(2));   //返回2223,返回第二组匹配到的子字符串
        System.out.println(matcher.group());    //返回 aaa2223

    }

}

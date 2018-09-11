package com.jiehang.proxy.cglib;

public class Client {
    public static void main(String[] args) {
        TsmGuidDao tsmGuidDao = new TsmGuidDao();
        TsmCglib tsmCglib = new TsmCglib();
        TsmGuidDao proxy = (TsmGuidDao) tsmCglib.getInstance(tsmGuidDao);
        proxy.query();
    }
}

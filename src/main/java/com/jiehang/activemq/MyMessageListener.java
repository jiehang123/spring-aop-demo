package com.jiehang.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.MessageListener;
import java.util.concurrent.*;

public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "-->" + ((TextMessage) message).getText());
        } catch (InterruptedException | JMSException e) {
            e.printStackTrace();
        }
    }

}

class ListenerClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_jms.xml");
    }

}


/**
 * MessageListener 就是一个线程所在的消费者，在这里再开启一个线程池去消费消费，onMessage方法就会直接返回，那就不断有消息会进来executor中，BlockingQuene立刻就会爆满，线程池就会采取拒绝策略。
 */
//public class MyMessageListener implements javax.jms.MessageListener {
//
//    ExecutorService executor = new ThreadPoolExecutor(8, 10, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(20));
//
//    @Override
//    public void onMessage(Message message) {
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(Thread.currentThread().getName() + "-->" + ((TextMessage) message).getText());
//                    Thread.sleep(5000);
//                } catch (InterruptedException | JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }
//}

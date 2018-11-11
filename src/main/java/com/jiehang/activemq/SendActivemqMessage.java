package com.jiehang.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class SendActivemqMessage {

    public static void main(String[] args) throws JMSException {
//        sendMessage();
        startReceive(0, 20);
        startReceive(20, 60);
        startReceive(60, 95);
        startReceive(95, 1001);
    }

    private static void startReceive(final int min, final int max) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    receiveMessage(min, max);
                } catch (JMSException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private static void sendMessage() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://45.32.21.110:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(new ActiveMQQueue("JIEH_TEST_ONE"));
        Message message;
        for (int i = 0; i < 100; i++) {
            message = session.createTextMessage("Test Message == " + i);
            message.setIntProperty("kk", i);
            producer.send(message);
        }
        session.close();
        connection.close();
    }

    private static void receiveMessage(int min, int max) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://45.32.21.110:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        String messageSelector = "kk >= " + min + " and kk < " + max;
        MessageConsumer consumer = session.createConsumer(new ActiveMQQueue("JIEH_TEST_ONE"), messageSelector);
        connection.start();
        for (int i = 0; i < 100; i++) {
            TextMessage receiveMessage = (TextMessage) consumer.receive();
            System.out.println(Thread.currentThread().getName() + "<---->" + receiveMessage.getText());
            Thread.sleep(500);
        }
        session.close();
        connection.close();
    }

}

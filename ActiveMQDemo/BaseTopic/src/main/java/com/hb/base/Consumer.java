package com.hb.base;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-06 16:20
 */
public class Consumer {
    public static void main(String[] args) throws JMSException, IOException {
        //创建连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.188.133:61616");
        //获取连接
        Connection connection = factory.createConnection();
        //启动连接
        connection.start();
        //获取session 是否启动事务 消息确认模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建话题 并命名
        Topic mytopic = session.createTopic("mytopic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(mytopic);
        //监听消息 匿名内部类
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                MapMessage msg = (MapMessage) message;
                try {
                    String name = msg.getString("name");
                    int age = msg.getInt("age");
                    System.out.println("消费者接收的信息:姓名："+name+"，年龄:"+age);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}

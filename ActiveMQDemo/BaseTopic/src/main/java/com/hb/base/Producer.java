package com.hb.base;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author hb
 * @create 2020-08-06 16:12
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
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
        //创建消息生产者
        MessageProducer producer = session.createProducer(mytopic);
        //创建消息类型
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setString("name","hb");
        mapMessage.setInt("age",23);
        //发送消息
        producer.send(mapMessage);
        //关闭对象
        producer.close();
        session.close();
        connection.close();
    }
}

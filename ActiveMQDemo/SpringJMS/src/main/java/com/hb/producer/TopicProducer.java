package com.hb.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author hb
 * @create 2020-08-06 16:56
 */
public class TopicProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mq-producer.xml");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        ActiveMQTopic mqTopic = context.getBean(ActiveMQTopic.class);

        jmsTemplate.send(mqTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("springTopic-Producer-订阅");
            }
        });
    }
}

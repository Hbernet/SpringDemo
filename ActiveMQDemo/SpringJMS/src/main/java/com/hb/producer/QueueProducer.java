package com.hb.producer;

import org.apache.activemq.command.ActiveMQQueue;
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
public class QueueProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mq-producer.xml");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        ActiveMQQueue mqQueue = context.getBean(ActiveMQQueue.class);

        jmsTemplate.send(mqQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("springQueue-Producer-点对点");
            }
        });
    }
}

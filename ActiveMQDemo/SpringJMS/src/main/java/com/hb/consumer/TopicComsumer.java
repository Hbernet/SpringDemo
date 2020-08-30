package com.hb.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-06 20:59
 */
public class TopicComsumer {
    public static void main(String[] args) {
       new ClassPathXmlApplicationContext("classpath:applicationContext-mq-consumer.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

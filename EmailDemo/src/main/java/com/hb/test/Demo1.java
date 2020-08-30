package com.hb.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author hb
 * @create 2020-08-16 8:15
 */
public class Demo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        JavaMailSenderImpl mailsend=(JavaMailSenderImpl) context.getBean("mailSender");

        //创建简单的邮件
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("hbernet@163.com");
        msg.setTo("1468612451@qq.com");
        msg.setSubject("测试邮件");
        msg.setText("好好学习,天天向上!");

        //发送邮件
        mailsend.send(msg);

        System.out.println("send ok");

    }
}

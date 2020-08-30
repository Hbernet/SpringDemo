package com.hb.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author hb
 * @create 2020-08-16 10:01
 */
public class Demo3 {
    public static void main(String[] args) throws MessagingException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        JavaMailSenderImpl mailsend=(JavaMailSenderImpl) context.getBean("mailSender");

        MimeMessage mimemsg = mailsend.createMimeMessage();

        MimeMessageHelper help = new MimeMessageHelper(mimemsg, true, "GBK");

        help.setFrom("hbernet@163.com");
        help.setTo("1468612451@qq.com");
        help.setSubject("html格式的邮件");
        String html="<!doctype html>"+
                "<html >"+
                "<head>"+
                "<meta charset=\"UTF-8\"> "+
                "<title>test mail</title>"+
                "</head>"+
                "<body>"+
                "<h1>这是一个html格式的邮件8</h1>"+
                "<i><b>演示斜体</b></i>"+
                "<img src='cid:www'>"+
                "</body>"+
                "</html>";
        //设定要发送的邮件内容,支持html
        help.setText(html, true);
        //在设定邮件嵌入图片,设定嵌入id
        help.addInline("www", new File("C:\\Users\\hb\\Pictures\\赵丽颖.jpg"));
        mailsend.send(mimemsg);
        System.out.println("send ok");

    }
}

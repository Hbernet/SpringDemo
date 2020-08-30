package com.hb.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author hb
 * @create 2020-08-16 9:46
 */
public class Demo2 {
    public static void main(String[] args) throws MessagingException {
        //初始化spring环境
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
        JavaMailSenderImpl mailsend=(JavaMailSenderImpl) context.getBean("mailSender");

        //创建带附件的邮件对象
        MimeMessage mimeMsg = mailsend.createMimeMessage();
        //创建助手类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
        helper.setFrom("hbernet@163.com");
        helper.setTo("1468612451@qq.com");
        helper.setSubject("带附件的简单邮件");
        helper.setText("这是一封带附件的简单邮件,正文");

        File f1=new File("C:\\Users\\hb\\Pictures\\赵丽颖.jpg");

        helper.addAttachment("赵丽颖.jpg", f1);
        //发送邮件
        mailsend.send(mimeMsg);
        System.out.println("send ok");

    }
}

package com.hb.test;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-16 10:10
 */
public class Demo4 {
    public static void main(String[] args) throws MessagingException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        JavaMailSenderImpl mailsend=(JavaMailSenderImpl) context.getBean("mailSender");

        MimeMessage mimemsg = mailsend.createMimeMessage();

        MimeMessageHelper help = new MimeMessageHelper(mimemsg, true, "GBK");

        help.setFrom("hbernet@163.com");
        help.setTo("1468612451@qq.com");
        help.setSubject("html格式的邮件111");
        //加载邮件模板
        String html=IOUtils.toString(new FileInputStream("E:\\ideaworkspace\\EmailDemo\\src\\main\\resources\\1.html"),"utf-8");
        //设定要发送的邮件内容,支持html
        help.setText(html, true);
        //添加html嵌入图片
        help.addInline("www", new File("C:\\Users\\hb\\Pictures\\美女.jpg"));
        mailsend.send(mimemsg);
        System.out.println("send ok");

    }
}

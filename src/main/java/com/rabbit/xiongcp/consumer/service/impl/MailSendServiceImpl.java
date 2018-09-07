package com.rabbit.xiongcp.consumer.service.impl;

import com.rabbit.xiongcp.consumer.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;
import java.util.Set;


@Service
public class MailSendServiceImpl implements MailSendService {


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender = "18603039146@sina.cn";

    @Override
    @Async
    public void sendSimpleMail(String[] to, String subject, String content) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    @Async
    public void sendHtmlMail(String[] to, String subject, String html) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true);
        mailSender.send(message);
    }

    @Override
    @Async
    public void sendAttachmentsMail(String[] to, String subject, String content, Map<String, File> files) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);
        //注意项目路径问题，自动补用项目路径
        //FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
        //加入邮件
        //helper.addAttachment("图片.jpg", file);
        Set<Map.Entry<String,File>> fileSet = files.entrySet();
        for (Map.Entry f : fileSet) {
            helper.addAttachment((String) f.getKey(), (File) f.getValue());
        }
        mailSender.send(message);
    }
}

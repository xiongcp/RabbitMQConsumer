package com.rabbit.xiongcp.consumer.service;

import com.rabbit.xiongcp.consumer.entity.CheckEmail;
import com.rabbit.xiongcp.consumer.entity.Foo;
import com.rabbit.xiongcp.consumer.init.EmailTemple;
import com.rabbit.xiongcp.consumer.utils.FastJsonUtil;
import com.xiongcp.bug.manager.message.UserEmail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ${ClassName}
 * Created by xiongcp on 2018/9/7.
 */
@Component
public class ReceiverService {


    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private CheckEmailService checkEmailService;

    @RabbitListener(queues = "queue.foo")
    public void receiveFooQueue(Foo foo) {
        System.out.println("Received Foo<" + foo + ">");
    }

    @RabbitListener(queues = "queue.bar")
    public void receiveBarQueue(Date bar) {
        System.out.println("Received Bar<" + bar + ">");
    }


    @RabbitListener(queues = "queue.string")
    public void receiveStringQueue(String message) {
        System.out.println("Received Bar<" + message + ">");
        System.out.println("Received Bar<" + System.currentTimeMillis() + ">");
        if (message == null || message.equals("")) {
            return;
        }
        UserEmail userEmail = FastJsonUtil.getObject(message, UserEmail.class);
        if (userEmail == null || userEmail.getEmail().equals("")) {
            return;
        }
        try {
            mailSendService.sendSimpleMail(new String[]{userEmail.getEmail()}, EmailTemple.TITLE,
                    EmailTemple.CONTENT + userEmail.getCheckNumber());
            CheckEmail checkEmail = new CheckEmail();
            checkEmail.setCheckNumber(userEmail.getCheckNumber());
            checkEmail.setSendEmail(userEmail.getSendEmail());
            checkEmail.setEmail(userEmail.getEmail());
            checkEmail.setSendTime(new Date());
            checkEmailService.insertNewCheckEmail(checkEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

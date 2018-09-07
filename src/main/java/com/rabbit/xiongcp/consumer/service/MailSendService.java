package com.rabbit.xiongcp.consumer.service;

import java.io.File;
import java.util.Map;

/**
 * 邮箱发送类 不能保证邮件一定能够发送成功
 * Created by Administrator on 2018/9/6
 */
public interface MailSendService {
    /**
     * 发送简单文本邮件
     *
     * @param to      收件人，一组，不能为空
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws Exception
     */
    void sendSimpleMail(String[] to, String subject, String content) throws Exception;

    /**
     * 发送Html邮件
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param html    邮件内容，html
     * @throws Exception
     */
    void sendHtmlMail(String[] to, String subject, String html) throws Exception;

    /**
     * 发送带附件的邮件
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param files   附件,key请将文件的扩展名也加上，否则无法预览。如：picture.jpg
     * @throws Exception
     */
    void sendAttachmentsMail(String[] to, String subject, String content, Map<String, File> files) throws Exception;

}


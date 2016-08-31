package com.mail.controller;

import com.mail.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    //  /message/demnandtel@gmail.com/text/text
    @RequestMapping(value = "/message/{receiverEmail}/{subject}/{text}")
    public void sendMessage(
            @PathVariable String receiverEmail,
            @PathVariable String subject,
            @PathVariable String text
            ) throws MessagingException {

        mailService.sendMessageToEmail(receiverEmail, subject, text);
    }

}

package com.mail.service;

import com.mail.model.Message;
import com.mail.model.Person;
import com.mail.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void persistMessage(String receiverEmail, String subject, String text) {
        Person person = new Person(receiverEmail);
        Message message = new Message(subject, text, person);
        messageRepository.save(message);
    }

}

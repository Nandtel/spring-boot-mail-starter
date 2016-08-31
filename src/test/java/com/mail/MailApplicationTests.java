package com.mail;

import com.mail.model.Message;
import com.mail.repository.MessageRepository;
import com.mail.service.MessageService;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MailApplicationTests {

	@Autowired
	MessageService messageService;

	@Autowired
	MessageRepository messageRepository;

	@Before
	public void before() {
		messageService.persistMessage("demnandtel@gmail.com", "test", "test");
	}

	@After
	public void after() {
		messageRepository.deleteAll();
	}

	@Test
	public void hasOneMessage() {
		Assert.assertEquals(messageRepository.findAll().size(), 1);
	}

	@Test
	public void hasRightField() {
		Message message = messageRepository.findAll().get(0);

		Assert.assertEquals(message.getPerson().getEmail(), "demnandtel@gmail.com");
		Assert.assertEquals(message.getSubject(), "test");
		Assert.assertEquals(message.getText(), "test");
	}

}

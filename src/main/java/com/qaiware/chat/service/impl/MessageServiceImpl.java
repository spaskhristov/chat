package com.qaiware.chat.service.impl;

import com.qaiware.chat.exception.MessageValidationException;
import com.qaiware.chat.model.Message;
import com.qaiware.chat.repository.MessageRepository;
import com.qaiware.chat.service.MessageService;
import com.qaiware.chat.validation.MessageValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Service
public class MessageServiceImpl implements MessageService {

  private static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

  @Autowired
  public MessageValidator messageValidator;

  @Autowired
  private MessageRepository messageRepository;

  @Override
  public void create(Message message) throws MessageValidationException {
    if (messageValidator.validateMessage(message)) {
      messageRepository.save(message);
    } else {
      logger.info("Can not create message");
    }
  }

}

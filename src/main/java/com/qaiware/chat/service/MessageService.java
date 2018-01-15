package com.qaiware.chat.service;

import com.qaiware.chat.exception.MessageValidationException;
import com.qaiware.chat.model.Message;

/**
 * Service related with all messages
 *
 * @author Spas Hristov
 * @version 1.0.0
 */
public interface MessageService {

  /**
   * Create message.
   *
   * @param message must not be {@literal null}.
   */
  void create(Message message) throws MessageValidationException;

}

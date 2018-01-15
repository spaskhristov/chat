package com.qaiware.chat.exception;

import javax.validation.ValidationException;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
public class MessageValidationException extends ValidationException {

  public MessageValidationException(String msg) {
    super(msg);
  }

}

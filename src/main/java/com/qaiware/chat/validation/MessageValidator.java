package com.qaiware.chat.validation;

import com.qaiware.chat.exception.MessageValidationException;
import com.qaiware.chat.model.Message;
import com.qaiware.chat.util.MessageType;
import org.springframework.stereotype.Component;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Component
public class MessageValidator {

  /**
   * Returns the true when message type is {@link MessageType.EMOTION} and the payload length should
   * be between 2 and 10 and should not contain characters between 0 and 9
   * OR
   * {@link MessageType.TEXT} and the payload length should be between 1 and 160
   *
   * @param message Message object
   * @return true when message is valid
   * @throws MessageValidationException if the message is not valid
   */
  public boolean validateMessage(Message message) throws MessageValidationException {
    if (message != null && message.getPayload() != null && message.getType() != null) {
      if (MessageType.TEXT.equals(message.getType()) && message.getPayload() != null) {
        if (message.getPayload().length() >= 1 && message.getPayload().length() <= 160) {
          return true;
        } else {
          throw new MessageValidationException("Payload length must be between 1 and 160.");
        }
      } else if (MessageType.EMOTION.equals(message.getType())) {
        if (message.getPayload().length() >= 2 && message.getPayload().length() <= 10
            && !message.getPayload().matches(".*\\d+.*")) {
          return true;
        } else {
          throw new MessageValidationException("Payload length must be between 2 and 10.");
        }
      }
    }
    throw new MessageValidationException("Message validation failed.");
  }

}

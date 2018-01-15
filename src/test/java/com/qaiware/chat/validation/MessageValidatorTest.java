package com.qaiware.chat.validation;

import com.qaiware.chat.ChatApplication;
import com.qaiware.chat.exception.MessageValidationException;
import com.qaiware.chat.model.Message;
import com.qaiware.chat.util.MessageType;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@RunWith(JUnitParamsRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    classes = ChatApplication.class)
public class MessageValidatorTest {

  private MessageValidator messageValidator = new MessageValidator();

  // In case of send_text the payload length should be between 1 and 160
  @SuppressWarnings("unused")
  private Object[] invalidValuesWhenTypeIsText() {
    return new Object[]{
        null,
        new Message(MessageType.EMOTION, ""),
        new Message(MessageType.EMOTION,
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"),
    };
  }

  // In case of send_emotion the payload length should be between 2 and 10 and should not contain characters between 0 and 9
  @SuppressWarnings("unused")
  private Object[] invalidValuesWhenTypeIsEmotion() {
    return new Object[]{
        null,
        new Message(MessageType.EMOTION, ""),
        new Message(MessageType.EMOTION, "s"),
        new Message(MessageType.EMOTION, "sads2"),
        new Message(MessageType.EMOTION, "abcdefgdsdsddsfdfsa"),
        new Message(MessageType.EMOTION, "12345678910")
    };
  }

  // In case of send_text the payload length should be between 1 and 160
  @SuppressWarnings("unused")
  private Object[] validValuesWhenTypeIsText() {
    return new Object[]{
        new Message("a"),
        new Message("arerewrr"),
        new Message(
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"),
    };
  }

  // In case of send_emotion the payload length should be between 2 and 10 and should not contain characters between 0 and 9
  @SuppressWarnings("unused")
  private Object[] validValuesWhenTypeIsEmotion() {
    return new Object[]{
        new Message(MessageType.EMOTION, "aa"),
        new Message("fdgfgh"),
        new Message(MessageType.EMOTION,
            "asdfghjklo"),
    };
  }

  @Parameters(method = "invalidValuesWhenTypeIsText")
  @Test(expected = MessageValidationException.class)
  public void invalidValuesWhenTypeIsTextShouldThrowException(Message message)
      throws MessageValidationException {
    messageValidator.validateMessage(message);
  }

  @Parameters(method = "invalidValuesWhenTypeIsEmotion")
  @Test(expected = MessageValidationException.class)
  public void invalidValuesWhenTypeIsEmotionShouldThrowException(Message message)
      throws MessageValidationException {
    messageValidator.validateMessage(message);
  }

  @Parameters(method = "validValuesWhenTypeIsText")
  @Test
  public void validValuesWhenTypeIsTextShouldNotThrowException(Message message)
      throws MessageValidationException {
    Assert.assertTrue(messageValidator.validateMessage(message));
  }

  @Parameters(method = "validValuesWhenTypeIsEmotion")
  @Test
  public void validValuesWhenTypeIsEmotionShouldNotThrowException(Message message)
      throws MessageValidationException {
    Assert.assertTrue(messageValidator.validateMessage(message));
  }

}

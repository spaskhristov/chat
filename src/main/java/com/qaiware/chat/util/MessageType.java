package com.qaiware.chat.util;

import com.qaiware.chat.exception.MessageValidationException;
import java.util.Arrays;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
public enum MessageType {
  TEXT("send_text"),
  EMOTION("send_emotion");

  private String description;

  MessageType(String description) {
    this.description = description;
  }

  public String description() {
    return description;
  }

  /**
   * Returns the enum constant of FileType type with the specified name.
   *
   * @param desc description
   * @return the FileType instance for the corresponding description
   * @throws MessageValidationException if the text does not contain valid text content or the {@code
   * desc} is unsupported
   */
  public static MessageType find(String desc) throws MessageValidationException {
    return Arrays.stream(MessageType.values())
        .filter(e -> e.description.equals(desc))
        .findFirst()
        .orElseThrow(() -> new MessageValidationException(String.format("Unsupported type %s.", desc)));
  }
}


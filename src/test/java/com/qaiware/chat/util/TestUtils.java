package com.qaiware.chat.util;

import com.google.gson.Gson;
import java.text.MessageFormat;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
public final class TestUtils {

  public static String prepareURL(String formatUri, String param) {
    return MessageFormat.format(formatUri, param);
  }

  public static <Message> String messageToJson(Message message) {
    Gson gson = new Gson();
    return gson.toJson(message);
  }

}
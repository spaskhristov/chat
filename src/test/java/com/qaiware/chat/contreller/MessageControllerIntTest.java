package com.qaiware.chat.contreller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.qaiware.chat.ChatApplication;
import com.qaiware.chat.dto.MessageDTO;
import com.qaiware.chat.util.MessageType;
import com.qaiware.chat.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    classes = ChatApplication.class)
@AutoConfigureMockMvc
public class MessageControllerIntTest {

  private static final String FORMAT_URI = "/messages/{0}";

  @Autowired
  private MockMvc mvc;

  @Test
  public void status201WhenMessageDTOisCorrectAndTypeIsText() throws Exception {
    MessageDTO message = new MessageDTO("text");
    String url = TestUtils.prepareURL(FORMAT_URI, MessageType.TEXT.description());
    mvc.perform(post(url)
        .content(TestUtils.messageToJson(message))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  public void status201WhenMessageDTOisCorrectAndTypeIsEmotion() throws Exception {
    MessageDTO message = new MessageDTO("emotion");
    String url = TestUtils.prepareURL(FORMAT_URI, MessageType.EMOTION.description());
    mvc.perform(post(url)
        .content(TestUtils.messageToJson(message))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  public void status412WhenMessageDTOisNotCorrectAndTypeIsText() throws Exception {
    MessageDTO message = new MessageDTO("");
    String url = TestUtils.prepareURL(FORMAT_URI, MessageType.TEXT.description());
    mvc.perform(post(url)
        .content(TestUtils.messageToJson(message))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(412));
  }

  @Test
  public void status412WhenMessageDTOisNotCorrectAndTypeIsEmotion() throws Exception {
    MessageDTO message = new MessageDTO("s");
    String url = TestUtils.prepareURL(FORMAT_URI, MessageType.EMOTION.description());
    mvc.perform(post(url)
        .content(TestUtils.messageToJson(message))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(412));
  }

  @Test
  public void status412WhenMessageDTOisCorrectAndTypeIsNotCorrect() throws Exception {
    MessageDTO message = new MessageDTO("test");
    String url = TestUtils.prepareURL(FORMAT_URI, "test");
    mvc.perform(post(url)
        .content(TestUtils.messageToJson(message))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(412));
  }

}

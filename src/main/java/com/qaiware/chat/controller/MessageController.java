package com.qaiware.chat.controller;

import com.qaiware.chat.dto.MessageDTO;
import com.qaiware.chat.model.Message;
import com.qaiware.chat.service.MessageService;
import com.qaiware.chat.util.MessageType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Api(tags = {"Messages"})
@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {

  private static Logger logger = LoggerFactory.getLogger(MessageController.class);

  @Autowired
  private MessageService messageService;

  @Autowired
  private Mapper mapper;

  @ApiOperation(value = "Create new message", response = HttpStatus.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Successfully create new message"),
      @ApiResponse(code = 412, message = "Precondition Failed")})
  @PostMapping(path = "/{type}")
  public ResponseEntity<HttpStatus> createMessage(
      @ApiParam(value = "message type", allowableValues = "send_text,send_emotion") @PathVariable("type") String type,
      @ApiParam(value = "message object") @RequestBody MessageDTO messageDTO)
      throws Exception {
    MessageType messageType = MessageType.find(type);
    Message message = mapper.map(messageDTO, Message.class);
    message.setType(messageType);
    messageService.create(message);
    logger.info("Create new message");
    return new ResponseEntity(HttpStatus.CREATED);
  }

}

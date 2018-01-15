package com.qaiware.chat.controller;

import com.qaiware.chat.exception.MessageValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

  @ExceptionHandler({MessageValidationException.class})
  public ResponseEntity<HttpStatus> handleApplicationException(MessageValidationException e) {
    return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
  }

}

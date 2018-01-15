package com.qaiware.chat.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO implements Serializable {

  private static final long serialVersionUID = -5537710731356606494L;

  private String payload;

}

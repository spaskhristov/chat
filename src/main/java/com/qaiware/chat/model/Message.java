package com.qaiware.chat.model;

import com.qaiware.chat.util.MessageType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message implements Serializable {

  private static final long serialVersionUID = -6794721678504543926L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Enumerated(EnumType.STRING)
  private MessageType type;

  @Column(name = "payload", nullable = false)
  @Size(min = 1, max = 160)
  private String payload;

  @Setter(AccessLevel.PRIVATE)
  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  public Message(String payload) {
    this(MessageType.TEXT, payload);
  }

  public Message(MessageType type, String payload) {
    this.type = type;
    this.payload = payload;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("GMT")).toLocalDateTime();
  }

}

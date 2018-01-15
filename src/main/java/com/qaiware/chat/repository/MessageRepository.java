package com.qaiware.chat.repository;

import com.qaiware.chat.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}

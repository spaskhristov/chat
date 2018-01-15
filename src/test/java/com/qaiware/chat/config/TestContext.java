package com.qaiware.chat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Configuration
@ComponentScan("com.qaiware.chat")
@PropertySource("classpath:application-test.properties")
public class TestContext {

}

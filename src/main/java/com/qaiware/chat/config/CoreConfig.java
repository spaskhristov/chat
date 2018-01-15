package com.qaiware.chat.config;

import static java.util.Arrays.asList;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Spas Hristov
 * @version 1.0.0
 */
@Configuration
public class CoreConfig {

  @Bean
  public Mapper dozerBeanMapper() {
    DozerBeanMapper beanMapper = new DozerBeanMapper();
    beanMapper.setMappingFiles(asList("dozer-mapping.xml"));

    return beanMapper;
  }

}

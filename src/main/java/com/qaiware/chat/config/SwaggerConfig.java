package com.qaiware.chat.config;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * When your application is up and running, open http://localhost:8080/swagger-ui.html address for
 * the Swagger UI at your local environment
 *
 * @author Spas Hristov
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

  @Value("${api.rest.version}")
  private String apiVersion;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.qaiware.chat.controller"))
        .paths(PathSelectors.any())
        .build().directModelSubstitute(LocalDate.class, String.class)
        .genericModelSubstitutes(ResponseEntity.class);
  }

  // API base information
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Chat Rest API")
        .description("Chat Rest API Documentation with Swagger")
        .termsOfServiceUrl("Terms of service").version(apiVersion).build();
  }

}

package com.jos.dem.springboot.cucumber.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import com.jos.dem.springboot.cucumber.model.Person;
import com.jos.dem.springboot.cucumber.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class WebConfig {

  @Autowired
  private PersonService personService;

  @Bean
  public RouterFunction<ServerResponse> routes(){
    return RouterFunctions
      .route(GET("/persons"),
      request -> ServerResponse.ok().body(personService.getAll(), Person.class))
      .andRoute(GET("/persons/{nickname}"), 
      request -> ServerResponse.ok().body(personService.getByNickname(request.pathVariable("nickname")), Person.class));
  }

}
package com.jos.dem.springboot.cucumber;

import com.jos.dem.springboot.cucumber.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@ContextConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class PersonIntegrationTest {

  @Autowired
  private WebClient webClient;

  Flux<Person> executeGet() throws Exception {
    return webClient.get().uri("").retrieve()
    .bodyToFlux(Person.class);
  }

}

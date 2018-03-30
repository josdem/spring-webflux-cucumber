package com.jos.dem.springboot.cucumber;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import com.jos.dem.springboot.cucumber.model.Person;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  private WebClient webClient;

  @Before
  public void setup(){
    webClient = WebClient.create("http://localhost:8080/persons");
  }

  @Test
	public void executeGet() throws IOException {
    Flux<Person> result = webClient.get().uri("").retrieve().bodyToFlux(Person.class);    
    assertNotNull(result);
  }

}

package com.jos.dem.springboot.cucumber;

import java.util.List;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import com.jos.dem.springboot.cucumber.model.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
  private static final String url = "http://localhost:8080/persons";

  private RestTemplate restTemplate = new RestTemplate();

  @Test
	public void executeGet() throws IOException {
    List<Person> persons = restTemplate.getForObject(url, List.class);
    assertNotNull(persons);    
  }

}

package com.jos.dem.springboot.cucumber;

import java.util.List;

import com.jos.dem.springboot.cucumber.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class SpringIntegrationTest {

  @Autowired
  private RestTemplate restTemplate;

  List<Person> executeGet(String url) throws Exception {
    return restTemplate.getForObject(url, List.class);
  }
  
}
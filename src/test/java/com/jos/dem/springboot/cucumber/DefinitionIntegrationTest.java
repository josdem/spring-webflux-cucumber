package com.jos.dem.springboot.cucumber;

import java.util.List;

import com.jos.dem.springboot.cucumber.model.Person;

import cucumber.api.java.en.Given;

public class DefinitionIntegrationTest extends SpringIntegrationTest {
  private static final String url = "http://localhost:8080/persons";

  @Given("^the client calls /persons$")	
  public void shouldGetPersons() throws Exception {
    List<Person> persons = executeGet(url);    
  }

}

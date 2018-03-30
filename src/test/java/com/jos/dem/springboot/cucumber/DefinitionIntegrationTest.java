package com.jos.dem.springboot.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.jos.dem.springboot.cucumber.model.Person;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionIntegrationTest extends SpringIntegrationTest {
  private static final String url = "http://localhost:8080/persons";
  private List<Person> persons;

  @When("^the client wants persons$")	
  public void shouldCallPersons() throws Exception {
    persons = executeGet(url);    
  }

  @Then("^the client receives persons$")
  public void shouldGetPersosn() throws Exception {      
    assertEquals(5 , persons.size());
  }

}

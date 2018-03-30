package com.jos.dem.springboot.cucumber;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.jos.dem.springboot.cucumber.model.Person;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class DefinitionIntegrationTest extends SpringIntegrationTest {
  private List<Person> persons;

  @When("^the client wants persons$")	
  public void shouldCallPersons() throws Exception {
    Flux<Person> result = executeGet();  
    persons = result.collectList().block();
  }

  @Then("^the client receives persons$")
  public void shouldGetPersosn() throws Exception {      
    assertEquals(5 , persons.size());
    assertTrue(persons.contains(new Person("josdem", "joseluis.delacruz@gmail.com")));
    assertTrue(persons.contains(new Person("tgrip", "tgrip@email.com")));
    assertTrue(persons.contains(new Person("edzero", "edzero@email.com")));
    assertTrue(persons.contains(new Person("skuarch", "skuarch@email.com")));
    assertTrue(persons.contains(new Person("jeduan", "jeduan@email.com")));
  }

}

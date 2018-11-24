package com.jos.dem.springboot.cucumber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.springboot.cucumber.model.Person;

import java.util.List;

import cucumber.api.java.en.Then;
import reactor.core.publisher.Flux;

public class DefinitionIntegrationTest extends SpringIntegrationTest {

  @Then("^the client receives persons$")
  public void shouldGetPersons() throws Exception {
    List<Person> persons = executeGet().collectList().block();

    assertEquals(5 , persons.size());
    assertAll("person",
      () -> assertTrue(persons.contains(new Person("josdem", "joseluis.delacruz@gmail.com"))),
      () -> assertTrue(persons.contains(new Person("tgrip", "tgrip@email.com"))),
      () -> assertTrue(persons.contains(new Person("edzero", "edzero@email.com"))),
      () -> assertTrue(persons.contains(new Person("skuarch", "skuarch@email.com"))),
      () -> assertTrue(persons.contains(new Person("jeduan", "jeduan@email.com")))
    );
  }

}

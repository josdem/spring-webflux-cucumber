/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.springboot.cucumber;

import static org.junit.jupiter.api.Assertions.assertAll;

import com.jos.dem.springboot.cucumber.model.Person;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPersonTest extends PersonIntegrationTest {

  private Person person;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @When("^I request person by nickname \"([^\"]*)\"$")
  public void shouldGetPersonByNickname(String nickname) throws Exception {
    log.info("Running: I request person by nickname at " + new Date());
    person = getPerson(nickname).block();
  }

  @Then("I validate person data")
  public void shouldValidatePersonData() throws Exception {
    log.info("Running: I validate person data at " + new Date());

    assertAll("person",
        () -> assertEquals("josdem", person.getNickname()),
        () -> assertEquals("joseluis.delacruz@gmail.com", person.getEmail())
    );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

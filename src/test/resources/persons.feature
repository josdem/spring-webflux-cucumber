@SmokeTest
Feature: We can retrieve person data
  Scenario: We can retrieve all persons
    When I request all persons
    Then I validate all persons

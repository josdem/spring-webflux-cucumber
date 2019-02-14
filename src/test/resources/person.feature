@EndToEndTest
Feature: We can retrieve person data
  Scenario: We can retrieve specific person
    When I request person by nickname "josdem"
    Then I validate person data

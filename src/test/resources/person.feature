Feature: We can retrieve person data
  Scenario: We can retrieve all persons
    When I request all persons
    Then I validate all persons
  Scenario: We can retrieve specific person
    When I request person by nickname "josdem"
    Then I validate person data

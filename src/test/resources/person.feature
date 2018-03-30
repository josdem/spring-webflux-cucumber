Feature: Persons can be retrieved  
  Scenario: client makes call to GET /persons
    Given the client calls /persons
    When the client receives status code of 200
    Then the client receives persons
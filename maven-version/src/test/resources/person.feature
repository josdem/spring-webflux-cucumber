Feature: Persons can be retrieved
  Scenario: client makes call to GET persons
    When the client wants persons
    Then the client receives persons

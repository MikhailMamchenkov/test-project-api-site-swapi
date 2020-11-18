@functional
Feature: test One Scenarios

  Scenario: I should be able to create a new user
    Given endpoint
    When I sent a request
    Then response status code should be 200
    And I get a response
    And Checks the value of the 'count' field

  Scenario: I should be able to create a new user2
    Given endpoint
    When I get value from key homeworld from first request
    And I get value from key name from second request
    Then Assert what value equals Tatooine





@functional
Feature: test One Scenarios

  Scenario:  Send a GET request to https://swapi.dev/api/people/
  and check that the value of the count field is 82;

    Given endpoint
    When I sent a request
    Then response status code should be 200
    And I get a response
    And Checks the value of the 'count' field

  Scenario: Send a GET request to https://swapi.dev/api/people/1 and check if
  that the home planet of the Luke Skywalker character is called Tatooine.

    Given endpoint
    When I get value from key homeworld from first request
    And I get value from key name from second request
    Then Assert what value equals Tatooine





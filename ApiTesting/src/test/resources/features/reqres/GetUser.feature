Feature: Get User

  Background:
    Given I set the base url "https://reqres.in"

  @ui @smoke
  Scenario: Get a user by ID
    Given I send a GET request to "/api/users/2"
    Then the response status code should be 200

  @regression
  Scenario: Post a user by ID
    Given I send a POST request to "/api/users/2"
    Then the response status code should be 201

  @sanity
  Scenario: Put a user by ID
    Given I send a Put request to "/api/users/2"
    Then the response status code should be 201
Feature: Get Pet
  Background:
    Given User send request api endpoint resource

    Scenario: get Pet
        Given I have a pet with id 1
        When I get the pet by id
        Then I should get the pet with id 1
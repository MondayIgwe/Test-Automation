Feature: Test User login

  Scenario: Validate user can login
    Given a user with username john and password secret
    When the user logs in with username john and password secret
    Then the user should be successfully logged in
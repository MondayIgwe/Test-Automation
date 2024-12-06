Feature: login Functionality

  Background: As a user, I want to check login Functionality

  @smoke
  Scenario Outline: Validate user can login
    Given user enter username "<username>" and password "<password>"
    When the user logs in
    Then the user should be successfully logged in
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @regression
  Scenario Outline: Invalid login details
    Given user enter username "<username>" and password "<password>"
    When the user logs in
    Then the user should not be able to log in

    Examples:
      | username   | password      |
      | error_user | wrongpasscode |
Feature: Login to HRM Application
  As a user
  I want to login to HRM Application
  So that I can access the application
  Background:
    Given the user is on the login page

  @smoke
  Scenario: Login with valid credentials
    Given User is on page
    Then  validate data from web table

  @functional
  Scenario: To test valid login details
    Given the user """ home page"""
    And verify that is able to log in
      |username|password|
      |sam     | xdd    |
      |sam     | xdd    |
    When user select data from web table
      | name  | value | status |
      | john  | 1000  | paid   |
      | wole  | 1000  | paid   |
      | jerry | 1000  | paid   |

    Then validate data from web table

    ## second scenario
  Scenario Outline: To test valid login details
    When user enter username "<username>"
    And user enter password "<password>"
    Then User is logged in
    @functional
    Examples:
      | username       | password        |
      | user@mail.com  | userCODE!@#     |
      | admin@mail.com | adminPASS!@#123 |

  Scenario Outline: negative test - To test invalid login details
    When user enter username "<username>"
    And user enter password "<password>"
    Then User is not logged in
    But user should not see "<admin>" role
    And Error is should be displayed

    @regression
    Examples:
      | username       | password        | role     |
      | user@mail.com  | userCODE!@#     | Admin    |
      | admin@mail.com | adminPASS!@#123 | Reporter |

  @smoke @regression
  Scenario: Successful login
    When the user enters valid credentials
    Then the user should be redirected to the dashboard

  @wip
  Scenario: Login with invalid credentials
    When the user enters invalid credentials
    Then an error message should be displayed
Feature: Login to HRM Application
  As a user
  I want to login to HRM Application
  So that I can access the application

  @smoke
  Scenario: Login with valid credentials
    Given User is on page "https://opensource-demo.orangehrmlive.com/"
    When User enters username "Admin" and password "admin123"
    Then User should be able to login successfully
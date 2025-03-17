Feature: Test ATM dispenser

  Rule: Check the Preconditions
    Given the account balance should have
      And the card is valid
      And the ATM contains sufficient money

    @included
    Scenario: Test ATM dispense cash
      Given the account balance is $100
      When I insert the card
      And I request $20
      Then the ATM cashslot should dispense $20
      And the account balance should be $80

    @excluded
    Scenario: Test ATM dispense cash
      Given the account balance is $100
      When I insert the card
      And I request $20
      Then the ATM cashslot should dispense $20
      And the account balance should be $80
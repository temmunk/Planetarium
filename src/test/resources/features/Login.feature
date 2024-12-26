@US2 @SR1 @SR@ @SR3
Feature: Login Feature
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background: User is on the login page
      Given user is on the login page

    Scenario: User can log in with valid credentials
      When the user provides valid login username
      And the user provides a valid login password
      And the user submits the login credentials
      Then user should be redirected to the home page

    @UR1 @UR2 @UR3 @UR4 @UR5 @UR6
    Scenario Outline: User can't log in with invalid credentials
      When the user provides login username "<username>"
      And the user provides login password "<password>"
      And the user submits the login credentials
      Then the user should get a browser alert "<alert>"
      And the user should stay on the login page


      Examples:
      |username       | password        | alert               |
      |Batman         | b0ts            | Invalid Credentials |
      |1Robin         | Iamthenight1939 | Invalid Credentials |
      |1Robin         | pass            | Invalid Credentials |
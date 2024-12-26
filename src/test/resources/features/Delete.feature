Feature: Celestial Body Deletion
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Background:
    Given the user is logged in to delete

    Scenario: User attempts to deletes a valid Moon or Planet
      When the user deletes planet or moon
      Then the table refreshes and the user should see their planets and moons.



  Scenario Outline: User attempts to delete an invalid celestial body
      When the user deletes planet or moon "<data>"
      Then user should get a browser alert saying "<error message>"

      Examples:
      | data        | error message       |
      | #Moon       | Invalid moon name   |
      | !Planet     | Invalid moon name   |
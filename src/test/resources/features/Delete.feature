@US5
Feature: Delete Feature
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Background:
    Given the user is logged in to delete

    Scenario: User attempts to deletes a valid Moon or Planet
      When the user deletes planet or moon
      Then the table refreshes and the user should see their planets and moons.



  Scenario Outline: User attempts to delete an invalid moon
      When the user deletes moon "<data>"
      Then user should get a browser alert saying "<error message>"

      Examples:
      | data                                      | error message       |
      | #Moon                                     | Invalid moon name   |
      | Super_long_moon_name_that_will_break      | Invalid moon name   |

  Scenario Outline: User attempts to delete an invalid planet
    When the user deletes planet "<data>"
    Then user should get a browser alert saying "<error message>"

    Examples:
      | data                                        | error message       |
      | !Planet                                     | Invalid planet name   |
      | Super_long_planet_name_that_will_break      | Invalid planet name   |
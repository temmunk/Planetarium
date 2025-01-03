@US4
Feature: Add Feature
  As a user I want to add new planets and moons to the Planetarium so I can update my findings

  Background:
    Given the user is logged in

    Scenario: User adds a valid Planet
      When the user inputs valid planet name
      Then the table refreshes and the user should see their added planet

    Scenario: User adds a valid Moon
      When the user inputs valid moon name and planet id
      Then the table refreshes and the user should see their added moon


    Scenario Outline: User adds invalid Moon
      When the user inputs invalid moon name "<name>" or planetid "<planetId>"
      Then the user should receive an alert "<error message>"

      @MR1 @MR2 @MR3
      Examples:

      |name                                 | planetId  |error message       |
      |Moon!                                |  1        |Invalid moon name   |
      |MoonTest                             |  5        |Invalid planet ID   |
      |Super_long_moon_name_that_will_break |  2        |Invalid moon name   |
      |Titan                                |  1        |Invalid moon name   |

    Scenario Outline: User adds invalid Planet
      When the user inputs invalid planet name "<name>"
      Then user should receive an alert "<error message>"

      @PR1 @PR2 @PR3
      Examples:

        |name                                  | error message         |
        |Super_long_planet_name_that_will_break| Invalid planet name   |
        |Planet!                               | Invalid planet name   |
        |Mars                                  | Invalid planet name   |
Feature: Update user data

  Scenario: Update seoid of a user from the file
    Given the user data is loaded from the file
    When I update the seoid
    Then the seoid in the file should be "nv789510"
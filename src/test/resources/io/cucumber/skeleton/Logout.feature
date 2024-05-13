Feature: Logout Functionality

  Scenario: Successful logout
    Given I am on the dashboard page
    When I open the menu
    And I click the logout button
    Then I should be logged out successfully
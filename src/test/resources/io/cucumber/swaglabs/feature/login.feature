Feature: Login Functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message "<message>"

    Examples:
    | username         | password         | message                                                                   |
    | invalid_user     | invalid_password | Epic sadface: Username and password do not match any user in this service |
    | standard_user123 | secret_sauce     | Epic sadface: Username and password do not match any user in this service |
    |                  | invalid_password | Epic sadface: Username is required                                        |
    | standard_user123 |                  | Epic sadface: Password is required                                        |
    |                  |                  | Epic sadface: Username is required                                        |
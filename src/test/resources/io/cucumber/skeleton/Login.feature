Feature: Login Functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Unsuccessful login with invalid credentials. It is username not registered.
    Given I am on the login page
    When I enter username "standard_user123" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Unsuccessful login with invalid credentials. It is empty username field.
    Given I am on the login page
    When I enter username "" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Unsuccessful login with invalid credentials. It is empty password field.
    Given I am on the login page
    When I enter username "standard_user123" and password ""
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: Unsuccessful login with invalid credentials. It is empty username and password field.
    Given I am on the login page
    When I enter username "" and password ""
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"
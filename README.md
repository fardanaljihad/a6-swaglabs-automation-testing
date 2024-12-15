# Program Testing Login dengan Selenium dan Cucumber

Program ini adalah proyek sederhana yang menampilkan penggunaan Selenium dan Cucumber untuk menguji fitur login dan logout pada situs web `https://www.saucedemo.com/`.

<img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white"> <img src="https://img.shields.io/badge/-Maven-C71A36?style=flat&logo=apache-maven&logoColor=white"> <img src="https://img.shields.io/badge/-JUnit-25A162?style=flat&logo=junit&logoColor=white"> <img src="https://img.shields.io/badge/-Selenium-43B02A?style=flat&logo=selenium&logoColor=white"> <img src="https://img.shields.io/badge/-Cucumber-23D96C?style=flat&logo=cucumber&logoColor=white">

## Project Structure

Berikut adalah struktur direktori untuk program Selenium dan Cucumber menggunakan Maven.

## Prerequisites

1. Install Java (JDK). Java 8+.
2. Install Maven
3. Install WebDriver (ChromeDriver, GeckoDriver, dll.)
4. Install IDE (contoh: Visual Studio Code)

## How to run Program

1. Clone Project

```shell
git clone https://github.com/SetiaBudii/webautomationtesting.git
```

2. Open Project on IDE
3. Open the terminal by pressing `Ctrl + Shift + ~`.
4. Command to run all test cases: `mvn test`.
5. Command to run a specific test case: `mvn test -Dcucumber.filter.name="[scenario]"`.
6. Command for generating project report: `mvn site`.
7. Command to generate a test report: `mvn surefire-report:report`.

## List Features (Cucumber)

### Login Functionality

```shell
Scenario: Successful login
  Given I am on the login page
  When I enter username "standard_user" and password "secret_sauce"
  And I click the login button
  Then I should be logged in successfully
```

```shell
Scenario: Unsuccessful login with invalid credentials
  Given I am on the login page
  When I enter username "invalid_user" and password "invalid_password"
  And I click the login button
  Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
```

```shell
Scenario: Unsuccessful login with invalid credentials. It is username not registered.
  Given I am on the login page
  When I enter username "standard_user123" and password "secret_sauce"
  And I click the login button
  Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
```

```shell
Scenario: Unsuccessful login with invalid credentials. It is empty username field.
  Given I am on the login page
  When I enter username "" and password "invalid_password"
  And I click the login button
  Then I should see an error message "Epic sadface: Username is required"
```

### Logout Functionality

```shell
Scenario: Successful logout
  Given I am on the dashboard page
  When I open the menu
  And I click the logout button
  Then I should be logged out successfully
```

## Authors

- Fardan Al Jihad
- M. Naufal Al Ghani
- Yayang Setia Budi

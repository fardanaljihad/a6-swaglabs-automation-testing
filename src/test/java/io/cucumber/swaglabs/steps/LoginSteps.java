package io.cucumber.swaglabs.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.swaglabs.pages.LoginPage;
import io.cucumber.swaglabs.utils.DriverManager;

public class LoginSteps {
  WebDriver driver = DriverManager.getDriver();
  LoginPage objLoginPage = new LoginPage(driver);

  @Before
  public void setUp() {
    driver = DriverManager.getDriver();
  }

  @After
  public void tearDown() {
    DriverManager.closeDriver();
  }

  @Given("I am on the login page")
  public void iAmOnTheLoginPage() {
    driver.get("https://www.saucedemo.com/");
  }

  @When("I enter username {string} and password {string}")
  public void iEnterUsernameAndPassword(String username, String password) {
    objLoginPage.enterUsername(username);
    objLoginPage.enterPassword(password);
  }

  @And("I click the login button")
  public void iClickTheLoginButton() {
    objLoginPage.clickLoginButton();
  }

  @Then("I should be logged in successfully")
  public void iShouldBeLoggedInSuccessfully() {
    String expectedUrl = "https://www.saucedemo.com/inventory.html";
    String actualUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
  }

  @Then("I should see an error message {string}")
  public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
    String actualErrorMessage = objLoginPage.getMessage();
    assertEquals(expectedErrorMessage, actualErrorMessage);
  }
}

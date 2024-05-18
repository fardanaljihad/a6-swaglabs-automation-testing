package io.cucumber.swaglabs.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.swaglabs.pages.InventoryPage;
import io.cucumber.swaglabs.pages.LoginPage;
import io.cucumber.swaglabs.utils.DriverManager;

public class LogoutSteps {
  WebDriver driver = DriverManager.getDriver();
  LoginPage objLoginPage = new LoginPage(driver);
  InventoryPage objInventoryPage = new InventoryPage(driver);

  @Before
  public void setUp() {
    driver = DriverManager.getDriver();
  }

  @After
  public void tearDown() {
    DriverManager.closeDriver();
  }

  @Given("I am has logged in with valid credentials")
  public void i_am_has_logged_in_with_valid_credentials() {
    driver.get("https://www.saucedemo.com/");
    objLoginPage.enterUsername("standard_user");
    objLoginPage.enterPassword("secret_sauce");
    objLoginPage.clickLoginButton();
  }

  @Given("I am on the dashboard page")
  public void i_am_on_the_dashboard_page() {
    String expectedUrl = objInventoryPage.getUrl();
    String actualUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
  }

  @When("I open the menu")
  public void i_open_the_menu() {
    objInventoryPage.openMenu();
  }

  @When("I click the logout button")
  public void i_click_the_logout_button() {
    objInventoryPage.clickLogoutButton();
  }

  @Then("I should be logged out successfully")
  public void i_should_be_logged_out_successfully() {
    String expectedUrl = "https://www.saucedemo.com/";
    String actualUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
  }
}

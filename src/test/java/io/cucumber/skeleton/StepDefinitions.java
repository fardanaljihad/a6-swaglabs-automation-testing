package io.cucumber.skeleton;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {
    private int firstNumber;
    private int secondNumber;
    private int result;

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int number) {
        if (firstNumber == 0) {
            firstNumber = number;
        } else {
            secondNumber = number;
        }
    }

    @When("I press add")
    public void i_press_add() {
        result = firstNumber + secondNumber;
    }

    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(int expected) {
        assert result == expected;
    }
    }


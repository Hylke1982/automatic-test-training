package nl.codecentric.ttt.romannumerals.cucumber.simple;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by hylke on 04/10/2016.
 */
public class SimpleSteps {

    private int numberOfApples;

    @Given("^I have (\\d+) apples$")
    public void giveApples(final int numberOfApples) {

        this.numberOfApples = numberOfApples;
    }

    @When("^I loose (\\d+) apples$")
    public void iLooseApples(int looseApples) throws Throwable {
        numberOfApples -= looseApples;
    }


    @Then("^I have (\\d+) apples left$")
    public void iHaveApplesLeft(int numberOfApplesLeft) throws Throwable {
        assertEquals(numberOfApplesLeft, numberOfApples);
    }
}

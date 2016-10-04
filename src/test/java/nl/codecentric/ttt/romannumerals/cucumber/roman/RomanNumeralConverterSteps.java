package nl.codecentric.ttt.romannumerals.cucumber.roman;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.codecentric.ttt.romannumerals.RomanNumeralConverter;

import static org.junit.Assert.assertEquals;

/**
 * Created by hylke on 04/10/2016.
 */
public class RomanNumeralConverterSteps {

    private RomanNumeralConverter romanNumeralConverter;
    private String convert;

    @Given("roman numeral converter is available")
    public void givenConverterIsAvailable() {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @When("^I input (\\d+) into the converter$")
    public void iInputIntoTheConverter(int number) throws Throwable {
        this.convert = romanNumeralConverter.convert(number);
    }

    @Then("^I get the roman numeral (.*)$")
    public void iGetTheRomanNumeralI(final String expectedConvert) throws Throwable {
        assertEquals(expectedConvert, this.convert);
    }
}

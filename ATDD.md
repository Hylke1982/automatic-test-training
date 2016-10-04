#Automatic unit tests

Automatic unit testing exercises, based on Roman numeral conversion up to 6. 

- [Frameworks](#frameworks)
- [Test roman numeral converter](test-roman-numeral-converter)

##Frameworks

For running tests the following frameworks are used:

- JUnit
- Cucumber
- Spring test

##Test roman numeral converter

To build a test for the roman numeral converter test with cucumber framework, a understanding 
of the following cucumber concepts are required.

- Feature, a test description readable for humans
- A run file like SimpleCucumberFT. Execute the cucumber tests with class
- Glue code or steps that execute the code, based on the given, when, then statements in the feature file

Keep in mind that the cucumber framework is razor thin and that most of the interaction needs to be 
written by the developers themself.

**Excercise:** Write a cucumber test for interaction with the roman numeral converter, write one test 
with a scenario and one with a scenario outline.

Roman number cucumber Junit executer
```java
package nl.codecentric.ttt.romannumerals;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by hylke on 04/10/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"nl.codecentric.ttt.romannumerals.cucumber.roman"},features = {"classpath:features/roman"})
public class RomanNumeralConverterFT {
}
```

Introduce feature with test
```
Feature: Roman number converter

  Scenario: Convert to roman numeral
    Given roman numeral converter is available
    When I input 1 into the converter
    Then I get the roman numeral I

  Scenario Outline: Convert to roman numerals
    Given roman numeral converter is available
    When I input <number> into the converter
    Then I get the roman numeral <romannumeral>
    Examples:
      | number | romannumeral |
      | 1      | I            |
      | 2      | II           |
      | 4      | IV           |
      | 5      | V            |
```

And create feature steps
```java
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
```


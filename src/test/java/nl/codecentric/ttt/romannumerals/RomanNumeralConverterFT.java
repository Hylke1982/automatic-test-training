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

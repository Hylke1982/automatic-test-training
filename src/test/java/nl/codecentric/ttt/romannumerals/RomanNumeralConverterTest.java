package nl.codecentric.ttt.romannumerals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by hylke on 03/10/2016.
 */
public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;


    @Test // Indicates that this is test
    public void testDefaultConstructor() {
        final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter(); // Construct of class instance
        assertNotNull(romanNumeralConverter); // assert that generated value is created
        assertEquals("", romanNumeralConverter.getPrefix()); // validates that the default prefix is empty string
    }

}

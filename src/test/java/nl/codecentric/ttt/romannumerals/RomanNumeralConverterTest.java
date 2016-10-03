package nl.codecentric.ttt.romannumerals;

import org.junit.Test;

import static org.junit.Assert.*;

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


    @Test
    public void testConstructorWithNumberIs() {
        final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter("Number is "); // Construct of class instance with other constructor
        assertEquals("Number is ", romanNumeralConverter.getPrefix()); // validates that the default prefix is 'Number is '
    }


    @Test(expected = IllegalStateException.class) // Expect exception
    public void testConstructorWithNullAndJUnitException() {
        new RomanNumeralConverter(null); // Construct with illegal value
    }

    @Test
    public void testConstructorWithTryCatch() {
        try {
            new RomanNumeralConverter(null);
        } catch (final IllegalStateException e) {
            assertTrue(e.getMessage().contains("Prefix cannot be null")); // assertEquals does not work because how different JDK append text
        }
    }

}

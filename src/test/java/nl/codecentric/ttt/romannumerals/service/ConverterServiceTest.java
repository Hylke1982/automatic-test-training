package nl.codecentric.ttt.romannumerals.service;

import nl.codecentric.ttt.romannumerals.RomanNumeralConverter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hylke on 04/10/2016.
 */
public class ConverterServiceTest {

    @Mock // Indicate that this is mock
    private RomanNumeralConverter romanNumeralConverter;
    private ConverterService converterService;


    @Before
    public void before() {
        MockitoAnnotations.initMocks(this); // Start mockito for every test run
        converterService = new ConverterService(romanNumeralConverter); // Create converter service to test and inject mock
    }

    @Test
    public void testRomanNumeralConversion() {
        converterService.romanNumeralConversion(5); // Call method to test
        verify(romanNumeralConverter.convert(5), times(1)); // Verify if the underlying mock is called
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRomanNumeralConversionWithException() {
        // Throw a illegal argument exception when method convert is called (for any int)
        when(romanNumeralConverter.convert(anyInt())).thenThrow(IllegalArgumentException.class);
        converterService.romanNumeralConversion(5); // Call method to test
    }


}

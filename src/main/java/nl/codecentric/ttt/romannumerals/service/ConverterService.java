package nl.codecentric.ttt.romannumerals.service;

import nl.codecentric.ttt.romannumerals.RomanNumeralConverter;

/**
 * Created by hylke on 04/10/2016.
 */
public class ConverterService {


    private final RomanNumeralConverter romanNumeralConverter; // roman numeral converter

    public ConverterService(final RomanNumeralConverter romanNumeralConverter) {
        this.romanNumeralConverter = romanNumeralConverter;
    }

    public String romanNumeralConversion(final Integer number) {
        return romanNumeralConverter.convert(number); // Call the underlying roman numeral converter
    }
}

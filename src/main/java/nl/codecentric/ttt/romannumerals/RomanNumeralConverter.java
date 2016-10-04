package nl.codecentric.ttt.romannumerals;

/**
 * Created by hylke on 03/10/2016.
 */
public class RomanNumeralConverter {

    private final String prefix;


    public RomanNumeralConverter() {
        this("");
    }


    public RomanNumeralConverter(final String prefix) {
        if (null == prefix) throw new IllegalStateException("Prefix cannot be null");
        this.prefix = prefix;
    }


    public String getPrefix() {
        return prefix;
    }

    public String convert(final Integer number) {
        if (null == number) throw new IllegalArgumentException("Number cannot be null");

        String returnValue = "";

        int romanFiveCount = number / 5;
        int numberOneRemain = number % 5;
        int romanOneCount = numberOneRemain;

        for (int i = 0; i < romanFiveCount; i++) {
            returnValue += "V";
        }

        for (int i = 0; i < romanOneCount; i++) {
            returnValue += "I";
        }

        return returnValue;
    }
}

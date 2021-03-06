package nl.codecentric.ttt.romannumerals;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by hylke on 03/10/2016.
 */
public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Executed before all tests");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Executed after all tests");
    }

    @Before
    public void before() {
        romanNumeralConverter = new RomanNumeralConverter(); // Create a default constructor instance for every test
        System.out.println("Executed before every test");
    }

    @After
    public void after() {
        System.out.println("Executed after every test");
    }


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

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithNull() {
        romanNumeralConverter.convert(null);
    }

    @Test
    public void testConvertWithZero() {
        validateConvert(0, "");
    }

    @Test
    public void testConvertWithOne() {
        validateConvert(1, "I");
    }

    @Test
    public void testConvertWithTwo() {
        validateConvert(2, "II");
    }

    @Test
    public void testConvertWithThree() {
        validateConvert(3, "III");
    }

    @Test
    public void testConvertWithFive() {
        validateConvert(5, "V");
    }

    @Test
    public void testConvertWithFour() {
        validateConvert(4, "IV");
    }

    @Test
    public void testConvertWithSix() {
        validateConvert(6, "VI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithMinusOne(){
        romanNumeralConverter.convert(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithSeven(){
        romanNumeralConverter.convert(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithIntegerMinValue(){
        romanNumeralConverter.convert(Integer.MIN_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithIntegerMaxValue(){
        romanNumeralConverter.convert(Integer.MAX_VALUE);
    }

    private void validateConvert(final int number, final String romanNumeral) {
        final String returnedValue = romanNumeralConverter.convert(number);
        assertEquals(romanNumeral, returnedValue);
    }

}

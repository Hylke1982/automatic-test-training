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
        final String returnedValue = romanNumeralConverter.convert(0);
        assertEquals("", returnedValue);
    }

    @Test
    public void testConvertWithOne() {
        final String returnedValue = romanNumeralConverter.convert(1);
        assertEquals("I", returnedValue);
    }

    @Test
    public void testConvertWithTwo() {
        final String returnedValue = romanNumeralConverter.convert(2);
        assertEquals("II", returnedValue);
    }

    @Test
    public void testConvertWithThree() {
        final String returnedValue = romanNumeralConverter.convert(3);
        assertEquals("III", returnedValue);
    }

    @Test
    public void testConvertWithFive() {
        final String returnedValue = romanNumeralConverter.convert(5);
        assertEquals("V", returnedValue);
    }

}

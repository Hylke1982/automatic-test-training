#Automatic unit tests

Automatic unit testing exercises, based on Roman numeral conversion up to 6. 

- [Frameworks](#Frameworks)
- [Red, Yellow, Green, (Refactor)](#Red,-Yellow,-Green,-Refactor)
- [Construct behavior](#Construct-behavior)
- [before / after / beforeClass / afterClass](#before,-after,-beforeClass,-afterClass)
- [null input](#null-input)
- [Zero input](#Zero-input)
- [Convert 1](#Convert-1)
- [Convert 2 and 3](#Convert-2-and-3)
- [Convert 5](#Convert-5)
- [Convert 4 and 6](#Convert-4-and-6)
- [Bounderies](#Bounderies)
- Edge case 3

##Frameworks

For running tests the following frameworks are used:

- JUnit
- Mockito

##Red, Yellow, Green, Refactor

When create (unit) tests, a red, yellow, green cycle is a way that 
simplifies the way how well tested software is created. A good disciple and 
knowledge of the IDE is required to do this.

###Red, a test without implementation

The red phase is to create a test without implementation, the test will fail 
because no implementation is available

```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final NonExistent romanNumeralConverter = new NonExistent(); // Construct of class instance
}
```

###Yellow, a test where asserts are not met

The yellow phase, is where a basic setup of the method that is under test 
but where the asserts are not met.

```java 
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter(); // Construct of class instance
    assertNotNull(romanNumeralConverter); // assert that generated value is created
    assertEquals("", romanNumeralConverter.getPrefix()); // Assert fails when called
}
```

###Green, the test succeeds

The test is executed succesful
```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter(); // Construct of class instance
    assertNotNull(romanNumeralConverter); // assert that generated value is created
    assertEquals("", romanNumeralConverter.getPrefix()); // validates that the default prefix is empty string
}
```
And the expected behavior is implemented so that (all) tests passes.

```java
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
        this.prefix = prefix;
    }


    public String getPrefix() {
        return prefix;
    }
}
```

> After the tests are green refactoring can be applied!

##Construct behavior

When testing a class then validate if every construct variation behaves
as expected.

##Tests/functionality to implement

- A default construct
- A construct with other text value for example 'number is '
- A construct with null


###Test the default constructor

It is always a great idea to test the output without input

```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter(); // Construct of class instance
    assertNotNull(romanNumeralConverter); // assert that generated value is created
    assertEquals("", romanNumeralConverter.getPrefix()); // validates that the default prefix is empty string
}
```

###The with alternative constructor value

A constructor value could have impact on the behavior on the class that is tested. 
So it is important that value, edge cases and exceptions are tested.

> Choose test names that are self explaining
 
```java
@Test
public void testConstructorWithNumberIs() {
    final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter("Number is "); // Construct of class instance with other constructor
    assertEquals("Number is ", romanNumeralConverter.getPrefix()); // validates that the default prefix is 'Number is '
}
```

###Handle expections while contructing

Testing for exceptions, is testing for edge cases. It documents how **not** to use the software. 
Exceptions can be handled in a test two ways:

- Expect with JUnit annotation, it could be not precise enough
- Try-catch structure, complete control over the thrown exception


Throw an exception when prefix value is set to null

```java
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
}
```

Expect with JUnit as part of the @Test annotation

```java
@Test(expected = IllegalStateException.class) // Expect exception
public void testConstructorWithNullAndJUnitException(){
    new RomanNumeralConverter(null); // Construct with illegal value
}
```

Or make use a try-catch statement to also validate the exception. 
This can be useful when same exception is thrown in different scenarios.

```java
@Test
public void testConstructorWithTryCatch() {
    try {
        new RomanNumeralConverter(null);
    } catch (final IllegalStateException e) {
        assertTrue(e.getMessage().contains("Prefix cannot be null")); // assertEquals does not work because how different JDK append text
    }
}
```
##before, after, beforeClass, afterClass

JUnit offers extra controls to simplify tests and add control that is applied 
to every test before or after the test(s) are executed.

```java
@BeforeClass
public static void beforeClass(){
    System.out.println("Executed before all tests");
}

@AfterClass
public static void afterClass(){
    System.out.println("Executed after all tests");
}

@Before
public void before(){
    romanNumeralConverter = new RomanNumeralConverter(); // Create a default constructor instance for every test
    System.out.println("Executed before every test");
}

@After
public void after(){
    System.out.println("Executed after every test");
}
```

##null input

Now it is time to introduce a method that converts a number into a
roman numeral. The first thing that needs to be tested what happens when you 
apply the method with a null input. 
(Mind the red, yellow, green, refactor cycle)

The expected behavior that null, throws a illegal argument exception

Test
```java
@Test(expected = IllegalArgumentException.class)
public void testConvertWithNull(){
    romanNumeralConverter.convert(null);
}
```

Behaviour added to converter
```java
public void convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");
}
```

##Zero input
Next to null input, when testing methods it always a good idea to validate 
if the input is zero (0). Zero is a typical edge case situation and is
this situation a empty string must be returned.

Test
```java
@Test
public void testConvertWithZero() {
    final String returnedValue = romanNumeralConverter.convert(0);
    assertEquals("", returnedValue);
}
```

Behaviour added to converter
```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");
    return "";
}
```

##Convert 1

After validating the edge case zero, then it is time to actually convert values 
starting with 1.

```java
@Test
public void testConvertWithOne() {
    final String returnedValue = romanNumeralConverter.convert(1);
    assertEquals("I", returnedValue);
}
```

Behavior added to the converter method
```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");

    String returnValue = "";
    if(number==1){
        returnValue = "I";
    }

    return returnValue;
}
```

##Convert 2 and 3
When convert number 2 into II then it becomes clear why refactoring 
is a important part of building up unit tests.

First write the test for these variations

```java
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
```

First make the test pass, with this code that is not optimized.
```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");

    String returnValue = "";
    if (number == 1) {
        returnValue = "I";
    } else if (number == 2) {
        returnValue = "II";
    } else if (number == 3) {
        returnValue = "III";
    }

    return returnValue;
}
```

Then refactor the code and validate if all tests are still passing.
```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");

    String returnValue = "";
    for(int i = 0; i < number;i++){
        returnValue += "I";
    }

    return returnValue;
}
```
##Convert 5

The number 5 converts to V, meaning that a new strategy is required to do this 
conversion. But first create a test validating for this value.

```java
@Test
public void testConvertWithFive() {
    final String returnedValue = romanNumeralConverter.convert(5);
    assertEquals("V", returnedValue);
}
```

Added this behavior to the converter method
```java
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
```

It is now a great moment to refactor the tests, for almost every number conversion 
there the same methods are applied. Refactoring the test keeps these tests maintable. 
If for example the method signature changes, the refactoring of the tests becomes minimal.

```java
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

private void validateConvert(int number, String romanNumeral) {
    final String returnedValue = romanNumeralConverter.convert(number);
    assertEquals(romanNumeral, returnedValue);
}
```

##Convert 4 and 6

Converting to 4 and 6 are typical edge cases while converting to roman numerals. Therefore 
it is very wise to test these conditions.

Tests
```java
@Test
public void testConvertWithFour() {
    validateConvert(4, "IV");
}

@Test
public void testConvertWithSix() {
    validateConvert(6, "VI");
}
```

Changed convert method, if number are going to be bigger another algorithm is required.
```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");

    String returnValue = "";

    int romanFiveCount = number / 5;
    int numberOneRemain = number % 5;

    if (numberOneRemain == 4) {
        returnValue += "I";
        romanFiveCount = 1;
        numberOneRemain = 0;
    }
    int romanOneCount = numberOneRemain;

    for (int i = 0; i < romanFiveCount; i++) {
        returnValue += "V";
    }

    for (int i = 0; i < romanOneCount; i++) {
        returnValue += "I";
    }

    return returnValue;
}
```

##Bounderies
Bounderies are great to validate in a unit test, you can prevent incorrect input 
into your application and inform the user what is going wrong.

For this test the input value cannot be lower than zero or higher than six, and 
when called with a invalid number a illegalargument exceptions is thrown.

It also wise to test the max and min integer values to see if there is no odd 
behavior at the ends of the range.

Tests
```java
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
```
Something interesting happens when the tests are executed without implementation. 
The Integer Max Value will probably hang for a long time, this is caused by the 
for-loop that is going from 0 to the max integer value.

```java
public String convert(final Integer number) {
    if (null == number) throw new IllegalArgumentException("Number cannot be null");
    if(isNotValidRange(number)) throw new IllegalArgumentException("Number not in range");

    String returnValue = "";

    int romanFiveCount = number / 5;
    int numberOneRemain = number % 5;

    if (numberOneRemain == 4) {
        returnValue += "I";
        romanFiveCount = 1;
        numberOneRemain = 0;
    }
    int romanOneCount = numberOneRemain;

    for (int i = 0; i < romanFiveCount; i++) {
        returnValue += "V";
    }

    for (int i = 0; i < romanOneCount; i++) {
        returnValue += "I";
    }

    return returnValue;
}

private boolean isNotValidRange(Integer number) {
    return !(number >= 0 && 7 > number);
}
```
Now a situation occurs where the same exception is thrown in two different cases 
If would recommended that the message of the exception is validated.

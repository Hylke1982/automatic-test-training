#Automatic testing

Automatic test training

##Automatic unit tests

- [Frameworks](#Frameworks)
- [Red, Yellow, Green, (Refactor)](#Red, Yellow, Green, Refactor)
- [Construct behavior](#Construct behavior)
- [before / after / beforeClass / afterClass](before / after / beforeClass / afterClass)
- Null state method
- Simple case 1
- Simple case 2
- Simple case 3
- Simple case 3
- Edge case 1
- Edge case 2
- Edge case 3

###Frameworks

For running tests the following frameworks are used:

- JUnit
- Mockito

###Red, Yellow, Green, Refactor

When create (unit) tests, a red, yellow, green cycle is a way that 
simplifies the way how well tested software is created. A good disciple and 
knowledge of the IDE is required to do this.

####Red, a test without implementation

The red phase is to create a test without implementation, the test will fail 
because no implementation is available

```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final NonExistent romanNumeralConverter = new NonExistent(); // Construct of class instance
}
```

####Yellow, a test where asserts are not met

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

####Green, the test succeeds

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

###Construct behavior

When testing a class then validate if every construct variation behaves
as expected.

###Tests/functionality to implement

- A default construct
- A construct with other text value for example 'number is '
- A construct with null


####Test the default constructor

It is always a great idea to test the output without input

```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter(); // Construct of class instance
    assertNotNull(romanNumeralConverter); // assert that generated value is created
    assertEquals("", romanNumeralConverter.getPrefix()); // validates that the default prefix is empty string
}
```

####The with alternative constructor value

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

####Handle expections while contructing

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
###before / after / beforeClass / afterClass

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










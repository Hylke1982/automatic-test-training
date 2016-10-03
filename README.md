# Automatic testing

Tests to build



[TOC]

## Automatic unit tests

- Red, Yellow, Green
- Construct behavior
- before / after / beforeClass / afterClass
- Null state method
- Simple case 1
- Simple case 2
- Simple case 3
- Simple case 3
- Edge case 1
- Edge case 2
- Edge case 3

### Red, Yellow, Green

When create (unit) tests, a red, yellow, green cycle is a way that 
simplifies the way how well tested software is created. A good disciple and 
knowledge of the IDE is required to do this.

#### Red, a test without implementation

The red phase is to create a test without implementation, the test will fail 
because no implementation is available

```java
@Test // Indicates that this is test
public void testDefaultConstructor() {
    final NonExistent romanNumeralConverter = new NonExistent(); // Construct of class instance
    assertNotNull(romanNumeralConverter); // assert that generated value is created
    assertEquals("", romanNumeralConverter.getPrefix()); // validates that the default prefix is empty string
}
```

#### Yellow, a test where asserts are not met

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

#### Green, the test succeeds


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

### Construct behavior

When testing a class then validate if every construct variation behaves
as expected.

#### Tests/functionality to implement

- A default construct
- A construct with other text value for example 'number is '
- A construct with null




```java

```



#Automatic unit tests

Automatic unit testing exercises, based on Roman numeral conversion up to 6. 

- [Frameworks](#frameworks)
- [Red, Yellow, Green, (Refactor)](#red,-yellow,-green,-refactor)
- [Construct behavior](#construct-behavior)
- [before / after / beforeClass / afterClass](#before,-after,-beforeclass,-afterclass)
- [null input](#null-input)
- [Zero input](#zero-input)
- [Convert 1](#convert-1)
- [Convert 2 and 3](#convert-2-and-3)
- [Convert 5](#convert-5)
- [Convert 4 and 6](#convert-4-and-6)
- [Bounderies](#bounderies)
- [Mockito](#mockito)

##Frameworks

For running tests the following frameworks are used:

- JUnit
- Mockito

##Red, Yellow, Green, Refactor

When creating (unit) tests, a red, yellow, green cycle is a way that 
simplifies the way how well tested software is created. A good disciple and 
knowledge of the IDE is required to do this.

###Red, a test without implementation

The red phase is to create a test without implementation, the test will fail 
because no implementation is available.

**Exercise:** Create test without implementation. Create a test that construct an 
instance of RomanNumeralConverter and test if the *getPrefix()* method returns empty 
string. (note: method does not exist yet)

###Yellow, a test where asserts are not met

The yellow phase, is where a basic setup of the method that is under test 
but where the asserts are not met.

**Exercise:** Implement *getPrefix()* method in the RomanNumeralConverter class, run 
the test and see if the assert fails. Assert that the result of the method *getPrefix()* is 
an empty String.

###Green, the test succeeds

**Excercise:** Implement the expect behaviour in the *getPrefix()* method, and see if 
all the test now are passing.

And the expected behavior is implemented so that (all) tests passes.

> After the tests are green refactoring can be applied!

##Construct behavior

When testing a class then validate if every construct variation behaves
as expected.

##Tests/functionality to implement

- A default construct
- A construct with other text value for example 'number is '
- A construct with null


###Test the default constructor

It is always a great idea to test the output without input, when applicable. This means 
test the default java constructor.

**Exercise:** Create a test that validates the workings of the constructor. For example 
validate if a getter value is set as expected using the constructor. (Introduce a prefix field 
in the RomanNumeralConverter and set this to empty String in the constructor, return the value 
in the *getPrefix()* method)


###The with alternative constructor value

A constructor value could have impact on the behavior on the class that is tested. 
So it is important that value, edge cases and exceptions are tested.

> Tip: Choose test names that are self explaining

**Exercise** Create another constructor in the RomanNumeralConverter that allows to set 
the field prefix in the class. Validate with a test if the *getPrefix()* method returns the 
expected value.

###Handle expections while contructing

Testing for exceptions, is testing for edge cases. It documents how **not** to use the software. 
Exceptions can be handled in a test two ways:

- Expect with JUnit annotation, it could be not precise enough
- Try-catch structure, complete control over the thrown exception


Throw an exception when prefix value is set to null

**Exercise:** Create a constructor when a prefix is set to null an illegal state exception is thrown,
 and validate with *@Test(expected = IllegalStateException.class)*.
**Exercise:** Also validate with a try-catch within a test

##before, after, beforeClass, afterClass

JUnit offers extra controls to simplify tests and add control that is applied 
to every test before or after the test(s) are executed.

**Exercise:** Print a line before and after every test using @after and @before. 
System.out.println can be used to print text to the console


##null input

Now it is time to introduce a method that converts a number into a
roman numeral. The first thing that needs to be tested what happens when you 
apply the method with a null input. 
(Mind the red, yellow, green, refactor cycle)

The expected behavior that null, throws a illegal argument exception

**Exercise:** Create a test where a method *convert* is called with input value *null*, 
when this method is called a illegal argument exception is thrown. 
Apply the red, yellow, green, refactor approach

##Zero input
Next to null input, when testing methods it always a good idea to validate 
if the input is zero (0). Zero is a typical edge case situation and is
this situation a empty string must be returned.

**Exercise:** Create a test where *0* is the input value for the *convert* method, 
the output for the method is a empty string.

##Convert 1

After validating the edge cases zero and null, then it is time to actually convert values 
starting with 1.

**Exercise:** Create a test where *0* is the input value for the *convert* method, 
the output for the method is a *I*. Choose a semantic name for your test to clarify the 
behavior of the test.

##Convert 2 and 3
When convert number 2 into II then it becomes clear why refactoring 
is a important part of building up unit tests.

**Excercise:** Write a test to validate input values *2* and *3*, and implement the behavior in 
the *convert* in the most simple way. Make the test pass and now apply refactoring to the *convert* 
method to be more generic. (Tests still have to pass)

##Convert 5

The number 5 converts to V, meaning that a new strategy is required to do this 
conversion. But first create a test validating for this value.

**Exercise:** Create a test where *5* is the input for the convert method, and expect that 
*V* is the expected result.

It is now a great moment to refactor the tests, for almost every number conversion 
there the same methods are applied. Refactoring the test keeps these tests maintable. 
If for example the method signature changes, the refactoring of the tests becomes minimal.


##Convert 4 and 6

Converting to 4 and 6 are typical edge cases while converting to roman numerals. Therefore 
it is very wise to test these conditions.

**Exercise:** Add tests for input values *4* and *6* and expect the method to return *IV* and *VI*.
After the implementation improve the algorithm in the *convert* method, and validate if the tests 
are still passing.

##Bounderies
Bounderies are great to validate in a unit test, you can prevent incorrect input 
into your application and inform the user what is going wrong.

For this test the input value cannot be lower than zero or higher than six, and 
when called with a invalid number a illegalargument exceptions is thrown.

It also wise to test the max and min integer values to see if there is no odd 
behavior at the ends of the range.

**Exercise:** Create tests that throw a IllegalArgumentException when the input is smaller than 0 or larger then 6. 
Also validate the min and max values of Integer

##Mockito
The RomanNumeralConverter will probably be imported in some other classes, but 
as a developer/tester is necessary to keep the isolation of a unit test to one 
class, one method in one variation. Mockito is a framework that allows for this
to simulate/control interactions with one method with another class.

For example if a converter service is introduced where different conversions can be done 
a every conversion is delegated to a different converter.

**Exercise:** Create a ConverterService with test, introduce the method convert into the 
ConvertService class. The ConverterService convert method will call the RomanNumeralConverter 
convert method. With mockito create two tests where one uses Mockito *verify* and the other one 
use Mockito *when*.

Now it time to proceed to the [Integration test](INTEGRATION.md)
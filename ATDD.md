#Automatic unit tests

Automatic unit testing exercises, based on Roman numeral conversion up to 6. 

- [Frameworks](#frameworks)
- [Test roman numeral converter](test-roman-numeral-converter)

##Frameworks

For running tests the following frameworks are used:

- JUnit
- Cucumber
- Spring test

##Test roman numeral converter

To build a test for the roman numeral converter test with cucumber framework, a understanding 
of the following cucumber concepts are required.

- Feature, a test description readable for humans
- A run file like SimpleCucumberFT. Execute the cucumber tests with class
- Glue code or steps that execute the code, based on the given, when, then statements in the feature file

Keep in mind that the cucumber framework is razor thin and that most of the interaction needs to be 
written by the developers themself.

**Excercise:** Write a cucumber test for interaction with the roman numeral converter, write one test 
with a scenario and one with a scenario outline.


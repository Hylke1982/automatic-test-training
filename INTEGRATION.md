# Integration testing

Integration testing is testing of the constellation of units and how these units work together. 
This is not only limited to software written by a single team, but also to the constellation of third 
party frameworks.

- [Building an spring context](#building-an-spring-context)
- [Time travelling](#time-travelling)

## Frameworks

Typical frameworks that can be used to do integration testing are:

- JUnit
- Mockito
- Spring-test
- DBUnit


##Building an spring context test

Spring framework is a framework that is used by a wide variety of application and companies. 
For that reason it very useful to know how to build up a Spring context and how to tests these 
contexts.

The framework controls the wiring of units together using the Spring context and it is very useful 
to test the wiring of these units, because could be different dependent on which environment you are 
running. Therefor it is very valid to test if you get the correct unit back with correct configuration 
from the context.

**Exercise:** Write two integration tests that validate if right implementation of the a RandomNumberService 
is returned when no profile is chosen or when the *followup* profile is active. Test classes are already added
but tests itself still have to be done.





##Time travelling

Making direct use of the (system) clock makes it very hard to test your application. It forces 
 to calculate date/time based instead of setting date/time based state.
 
**Exercise:** Create a clock service where the normal implementation returns the system time and 
a time travel service where a specific date/time can be set.




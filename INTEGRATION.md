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

Normal converter configuration test
```java
package nl.codecentric.ttt.romannumerals.configuration;

import nl.codecentric.ttt.romannumerals.service.FollowUpRandomNumberService;
import nl.codecentric.ttt.romannumerals.service.NormalRandomNumberService;
import nl.codecentric.ttt.romannumerals.service.RandomNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import static org.junit.Assert.assertTrue;

/**
 * Created by hylke on 04/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class) // Instruct JUnit to use Spring framework test helper
@ContextConfiguration(classes = {ConverterConfiguration.class, FollowUpConverterConfiguration.class}) // Load the right configuration
@TestExecutionListeners({DirtiesContextBeforeModesTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class ConverterConfigurationTest {

    @Autowired
    private RandomNumberService randomNumberService;


    @Test
    public void testCorrectInstanceRandomNumberService(){
        assertTrue(randomNumberService instanceof NormalRandomNumberService);
    }
}
```

Follow up configuration test
```java
package nl.codecentric.ttt.romannumerals.configuration;

import nl.codecentric.ttt.romannumerals.service.FollowUpRandomNumberService;
import nl.codecentric.ttt.romannumerals.service.RandomNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import static org.junit.Assert.assertTrue;

/**
 * Created by hylke on 04/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class) // Instruct JUnit to use Spring framework test helper
@ContextConfiguration(classes = {ConverterConfiguration.class, FollowUpConverterConfiguration.class}) // Load the right configuration
@ActiveProfiles(profiles = {"followup"})
@TestExecutionListeners({DirtiesContextBeforeModesTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class FollupUpConverterConfigurationTest {

    @Autowired
    private RandomNumberService randomNumberService;


    @Test
    public void testCorrectInstanceRandomNumberService(){
        assertTrue(randomNumberService instanceof FollowUpRandomNumberService);
    }
}
```




##Time travelling

Making direct use of the (system) clock makes it very hard to test your application. It forces 
 to calculate date/time based instead of setting date/time based state.
 
**Exercise:** Create a clock service where the normal implementation returns the system time and 
a time travel service where a specific date/time can be set.

First create an interface that shares the method contract

```java
package nl.codecentric.ttt.romannumerals.service;

import java.util.Date;

/**
 * Created by hylke on 04/10/2016.
 */
public interface ClockService {

    public Date getCurrentTime();
}
```

Normal implementation, where current time is returned
```java
package nl.codecentric.ttt.romannumerals.service;

import java.util.Date;

/**
 * Created by hylke on 04/10/2016.
 */
public class NormalClockService implements ClockService {
    public Date getCurrentTime() {
        return new Date();
    }
}
```

Time travel implementation where the date can be set.
```java
package nl.codecentric.ttt.romannumerals.service;

import java.util.Date;

/**
 * Created by hylke on 04/10/2016.
 */
public class TimeTravelClockService implements ClockService {

    private Date newDate;

    public void setDate(final Date newDate) {
        this.newDate = newDate;
    }

    public Date getCurrentTime() {
        return this.newDate;
    }
}
```




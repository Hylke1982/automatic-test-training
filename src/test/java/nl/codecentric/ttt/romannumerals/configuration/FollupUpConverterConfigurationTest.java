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

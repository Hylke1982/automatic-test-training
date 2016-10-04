package nl.codecentric.ttt.romannumerals.configuration;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hylke on 04/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class) // Instruct JUnit to use Spring framework test helper
@ContextConfiguration(classes = {ConverterConfiguration.class}) // Load the right configuration
@ActiveProfiles({"followup"})
public class FollupUpConverterConfigurationTest {
}

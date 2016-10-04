package nl.codecentric.ttt.romannumerals.configuration;

import nl.codecentric.ttt.romannumerals.service.NormalRandomNumberService;
import nl.codecentric.ttt.romannumerals.service.RandomNumberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by hylke on 04/10/2016.
 */
@Configuration
@Import({FollowUpConverterConfiguration.class})
public class ConverterConfiguration {

    @Bean(name = "randomNumberService")
    public RandomNumberService randomNumberService() {
        return new NormalRandomNumberService();
    }
}

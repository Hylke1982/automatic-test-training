package nl.codecentric.ttt.romannumerals.configuration;

import nl.codecentric.ttt.romannumerals.service.FollowUpRandomNumberService;
import nl.codecentric.ttt.romannumerals.service.RandomNumberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by hylke on 04/10/2016.
 */
@Profile(value = "followup")
@Configuration
public class FollowUpConverterConfiguration {

    @Bean(name = "randomNumberService")
    public RandomNumberService randomNumberService() {
        return FollowUpRandomNumberService.getInstance();
    }
}

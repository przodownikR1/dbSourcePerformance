package pl.java.scalatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
@Configuration
public class GeneratorConfig {
    @Bean
    public Resource carsResource(){
        return new org.springframework.core.io.ClassPathResource("car.txt");
    }
    @Bean
    public Resource female(){
        return new org.springframework.core.io.ClassPathResource("female_names.txt");
    }

    @Bean
    public Resource male(){
        return new org.springframework.core.io.ClassPathResource("male_names.txt");
    }

    @Bean
    public Resource skills(){
        return new org.springframework.core.io.ClassPathResource("skills.txt");
    }

    @Bean
    public Resource teams(){
        return new org.springframework.core.io.ClassPathResource("teams.txt");
    }

    @Bean
    public Resource country(){
        return new org.springframework.core.io.ClassPathResource("country.txt");
    }



}

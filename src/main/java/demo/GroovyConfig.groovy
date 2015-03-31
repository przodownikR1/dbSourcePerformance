package demo

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
class GroovyConfig {

    @Bean
    public String test(){
        return "slawek";
    }
}

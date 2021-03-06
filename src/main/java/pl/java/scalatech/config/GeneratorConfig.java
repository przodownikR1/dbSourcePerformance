/*
 * Copyright (C) 2016 Scalatech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.java.scalatech.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
@Configuration
@ComponentScan(basePackages="pl.java.scalatech.generator")
public class GeneratorConfig {
    @Bean
    public Random random(){
        return new Random();
    }

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

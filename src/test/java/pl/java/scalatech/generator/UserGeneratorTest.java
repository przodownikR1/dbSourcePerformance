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
package pl.java.scalatech.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.google.common.collect.Maps.newHashMap;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.GeneratorConfig;
import pl.java.scalatech.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GeneratorConfig.class })
@Slf4j
public class UserGeneratorTest {

    @Autowired
    private CountryGenerator countryGenerator;

    @Autowired
    private CarGenerator carGenerator;
    @Autowired
    private SimpleGenerator simpleGen;


    @Test
    public void test() {
        RandomPersonService rps = new RandomPersonService();
        List<User> users = rps.generate(20).collect(Collectors.toList());
        log.info(".... {}", users);
    }

    @Test
    public void shouldBootstap() {
        assertThat(true);
    }



    @Test
    public void shouldRetrieveCountryFromFile() {
            log.info("{}", countryGenerator.generateValue(newHashMap()));
    }
    @Test
    public void shouldRetrieveCarFromFile() {
            log.info("{}", carGenerator.generateValue(newHashMap()));
    }
    @Test
    public void shouldPersonGenWork(){
        log.info("{}",simpleGen.createPersonBatches(2));
    }
}

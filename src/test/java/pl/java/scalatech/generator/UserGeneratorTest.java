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

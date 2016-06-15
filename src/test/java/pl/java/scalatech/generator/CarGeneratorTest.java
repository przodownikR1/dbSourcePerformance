package pl.java.scalatech.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.GeneratorConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GeneratorConfig.class })
@Slf4j
public class CarGeneratorTest {

    @Resource
    private org.springframework.core.io.Resource carsResource;

    @Autowired
    private CarGenerator carGenerator;

    @Test
    public void shouldBootstap() {

        assertThat(true);
    }

    @Test
    public void shouldRetrieveFemaleFromFile() {
        try {
            log.info("{}", carGenerator.retrieveNames(Paths.get(carsResource.getURI()), s -> s.startsWith("A"), log));
        } catch (IOException e) {

        }
    }
}

package pl.java.scalatech.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.GeneratorConfig;
import pl.java.scalatech.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GeneratorConfig.class })
@Slf4j
public class UserGeneratorTest {

    @Resource
    private org.springframework.core.io.Resource female;

    @Resource
    private org.springframework.core.io.Resource male;

    @Autowired
    private RandomPersonService userGenerator;

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
    public void shouldReadFromFile() {

        try {
            userGenerator.readLineByLine(Paths.get(male.getURI()), s -> s.startsWith("A"), log, s -> log.info("{}", s));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void shouldRetrieveFemaleFromFile() {

        try {
            log.info("{}", userGenerator.retrieveNames(Paths.get(male.getURI()), s -> s.startsWith("A"), log));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

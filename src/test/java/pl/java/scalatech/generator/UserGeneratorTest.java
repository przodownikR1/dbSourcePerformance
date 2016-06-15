package pl.java.scalatech.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.GeneratorConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={GeneratorConfig.class})
@Slf4j
public class UserGeneratorTest {



    @Test
    public void shouldBootstap() {
        assertThat(true);
    }

}

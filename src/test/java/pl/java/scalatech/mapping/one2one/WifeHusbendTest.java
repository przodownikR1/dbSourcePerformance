package pl.java.scalatech.mapping.one2one;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
@Slf4j
@ActiveProfiles(value={"logger","dev"})
public class WifeHusbendTest {


    @Test
    public void shouldBootstap() {

        assertThat(true);
    }


}

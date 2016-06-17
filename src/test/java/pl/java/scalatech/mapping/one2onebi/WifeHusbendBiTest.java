package pl.java.scalatech.mapping.one2onebi;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.one2one.bi.Husband;
import pl.java.scalatech.domain.one2one.bi.Wife;
import pl.java.scalatech.repository.mapping.one2one.bi.HusbandBiRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestJpaConfig.class })
@Slf4j
@ActiveProfiles(value = { "logger", "dev" })
@Transactional
public class WifeHusbendBiTest {
    @Autowired
    private HusbandBiRepo repo;

    @Autowired
    private EntityManager em;

    @Test
    public void shouldBootstap() {
        assertThat(true);
    }

    @Test
    public void shouldSave() {
        Wife wife = new Wife();
        wife.setName("agnieszka");
        Husband husband = new Husband("slawek", wife);
        em.persist(husband);
    }
    @Test
    public void shouldRetrieve(){
        System.err.println("result " +repo.findAll());
         log.info("{}",repo.findAll());
    }

}

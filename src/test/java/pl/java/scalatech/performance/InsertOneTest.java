package pl.java.scalatech.performance;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.generator.SimpleGenerator;
import pl.java.scalatech.repository.sample.PersonRepo;
import pl.java.scalatech.timeTest.TimedTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PerformanceConfig.class})
@Transactional
@Slf4j
@ActiveProfiles(value={"logger","dev"})
public class InsertOneTest {
    @Rule
    public TimedTest timeTest = new TimedTest();

@Autowired
private PersonRepo personRepo;

@Autowired
private SimpleGenerator simpleGen;

@Test
public void shouldMeasureInserts(){
    personRepo.save(simpleGen.createPersonBatches(1000));
    log.info("{}",personRepo.findAll());
}


}

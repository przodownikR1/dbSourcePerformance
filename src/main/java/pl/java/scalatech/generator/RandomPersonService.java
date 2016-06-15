package pl.java.scalatech.generator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Gender;
import pl.java.scalatech.domain.User;
@Slf4j
@Component
public class RandomPersonService implements Generator<User>{
  Random random = new Random();

  private List<String> lastName = Stream.of(
          "Smith","Johnson", "Wong", "Lu", "Cobain", "Rockerfella", "Armstrong",
          "Alderan", "O'Connel", "Williams", "Brown","Jones","Miller","Garcia",
          "Martin","Moore","White","Jackson","Taylor","Lee","Harris", "Clark",
          "Robinson","Young","King","Scott","Green","Baker","Hill","Edwards"
  ).distinct().collect(Collectors.toList());




  public Supplier<User> personSupplier(){
    return () -> generate();
  }

  public User generate(){
    User toReturn = new User();


    toReturn.setGender( random.nextBoolean() ? Gender.FEMALE : Gender.MALE);
   // toReturn.setFirstname(toReturn.getGender() == Gender.FEMALE ? random(femaleName) : random(maleName));
    toReturn.setLastName(random(lastName));
    toReturn.setBirthDate(generateBirthDate());
    return toReturn;
  }

  public Stream<User> generate(Integer count){
    return generate(count.longValue());
  }

  public Stream<User> generate(Long count)
  {
    return LongStream.range(0,count).mapToObj(x->generate());
  }

  public LocalDate generateBirthDate(){
    return LocalDate.now()
            .minus(16l, ChronoUnit.YEARS )
            .minus(random.nextInt( 365 * 50),ChronoUnit.DAYS);
  }

  public String random(List<String> list){
    return list.get(random.nextInt(list.size()));
  }




@Override
public User generateValue(Map<String, Object> association) {
    return null;


}
}
package pl.java.scalatech.generator;

import static com.google.common.base.MoreObjects.firstNonNull;
import static java.nio.file.Paths.get;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.sample.Car;

@Slf4j
@Component
public class CarGenerator implements Generator<Car> {
    @Autowired
    private Random random;

    private String[] color= new String[]{"RED","BLUE","YELLOW","BLACK","WHITE","METALIC","SILVER"};

    @Resource
    private org.springframework.core.io.Resource carsResource;
    List<String> cars;

    @Override
    @SneakyThrows
    public Car generateValue(Map<String,Object> association) {
        cars = firstNonNull(cars,retrieveNames(get(carsResource.getURI()), s -> s.length()>2));
        return Car.builder().name(cars.get(random.nextInt(cars.size() - 1))).color(color[random.nextInt(color.length-1)]).productionDate(java.time.LocalDate.now()).build();

    }


}

package pl.java.scalatech.generator;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Car;

@Slf4j
@Component
public class CarGenerator implements Generator<Car> {


    @Override
    public Car generateValue(Map<String,Object> association) {
        return null;
        // TODO Auto-generated method stub

    }


}

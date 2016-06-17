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
import pl.java.scalatech.domain.sample.Country;

@Component
public class CountryGenerator implements Generator<Country> {
    @Autowired
    private Random random;

    private List<String> countries;

    @Resource
    private org.springframework.core.io.Resource country;

    @Override
    @SneakyThrows
    public Country generateValue(Map<String, Object> associations) {
        countries = firstNonNull(countries,retrieveNames(get(country.getURI()), s -> s.length()>2));
        return Country.builder().name(countries.get(random.nextInt(countries.size() - 1))).build();
    }

}

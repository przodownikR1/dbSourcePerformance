/*
 * Copyright (C) 2016 Scalatech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

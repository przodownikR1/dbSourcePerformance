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

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.java.scalatech.domain.Gender;
import pl.java.scalatech.domain.User;

public class PersonStatisticsService {

    public Map<Integer, Long> ageDistribution(Stream<User> personStream) {
        return personStream.map(User.age()).collect(groupingBy(x -> x, counting()));
    }

    public Map<Gender, Long> genderDistribution(Stream<User> personStream) {
        return personStream.collect(groupingBy(User::getGender, counting()));
    }

    public Map<Gender, LocalDate> averageBirthDateByGender(Stream<User> person) {
        return person.collect(groupingBy(User::getGender, averagingInt(x -> User.daysSinceBirth().apply(x)))).entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> LocalDate.now().minus(x.getValue().longValue(), ChronoUnit.DAYS)));
    }

    public LocalDate averageBirthdate(Stream<User> persons) {
        Double avg = persons.map(User.daysSinceBirth()).mapToInt(x -> x).average().getAsDouble();
        return LocalDate.now().minus(avg.longValue(), ChronoUnit.DAYS);
    }

}
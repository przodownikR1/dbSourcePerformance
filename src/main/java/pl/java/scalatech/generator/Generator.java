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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
@FunctionalInterface
public interface Generator<T> {


    T generateValue(Map<String, Object> associations);


     public default void readLineByLine(Path path,Predicate<String> filter, Logger log, Consumer<String> consumer) throws IOException {
        try (Stream<String> filteredLines = Files.lines(path).onClose(() -> log.info("close stream"))) {
            filteredLines.map(s -> s.trim()).filter(filter).distinct().forEach(consumer);
        }

    }


     public default List<String> retrieveNames(Path path,Predicate<String> filter, Logger log) throws IOException {
         try (Stream<String> filteredLines = Files.lines(path).onClose(() -> log.info("close stream"))) {
             return filteredLines.map(s -> s.trim()).filter(filter).distinct().collect(Collectors.toList());
         }

     }

     public default List<String> retrieveNames(Path path,Predicate<String> filter) throws IOException {
         try (Stream<String> filteredLines = Files.lines(path)) {
             return filteredLines.map(s -> s.trim()).filter(filter).distinct().collect(Collectors.toList());
         }

     }

}

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

}

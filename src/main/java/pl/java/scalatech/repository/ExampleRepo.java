package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Example;

public interface ExampleRepo extends JpaRepository<Example, Long>{


}

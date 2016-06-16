package pl.java.scalatech.repository.sample;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.sample.Person;

public interface PersonRepo extends JpaRepository<Person, Long>{

}

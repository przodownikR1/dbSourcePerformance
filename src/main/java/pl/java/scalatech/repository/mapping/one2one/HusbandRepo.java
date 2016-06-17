package pl.java.scalatech.repository.mapping.one2one;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.one2one.Husband;

public interface HusbandRepo extends JpaRepository<Husband, Long>{

}
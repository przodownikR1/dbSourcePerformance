package pl.java.scalatech.repository.mapping.one2one.bi;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.one2one.bi.Husband;

public interface HusbandBiRepo extends JpaRepository<Husband, Long>{

}

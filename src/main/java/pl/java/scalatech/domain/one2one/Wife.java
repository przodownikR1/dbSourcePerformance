package pl.java.scalatech.domain.one2one;

import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@GenericGenerator(name="genId", strategy="increment")
public class Wife extends AbstractEntity{

	private String name;
}
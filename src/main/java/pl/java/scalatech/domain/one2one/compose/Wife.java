package pl.java.scalatech.domain.one2one.compose;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@IdClass(WifePK.class)
public class Wife {
	@Id
	private int id;
	@Id
	private String name;

	private int age;
}
package pl.java.scalatech.domain.one2one.compose;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

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
public class Husband extends AbstractEntity{

	private String name;

	@OneToOne
	@JoinColumns(
		{
			@JoinColumn(name="wifeId",referencedColumnName="id"),
			@JoinColumn(name="wifeName",referencedColumnName="name")
		}
	)
	private Wife wife;
}
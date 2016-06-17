package pl.java.scalatech.domain.one2one.primary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Husband {
	@Id
	@GeneratedValue
	private int hid;
	private String name;

	@OneToOne(cascade=CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(columnDefinition="hid",name="hid",referencedColumnName="wid")
	private Wife wife;
}
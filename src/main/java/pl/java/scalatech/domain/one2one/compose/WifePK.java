package pl.java.scalatech.domain.one2one.compose;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WifePK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
}
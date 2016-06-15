package pl.java.scalatech.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@TableGenerator(name = "genId",table = "SEQUENCE_GENERATOR_TABLE",pkColumnName = "SEQUENCE_NAME",valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "CAR_SEQUENCE")
public class Car extends AbstractEntity{

    private static final long serialVersionUID = 3881863382462741952L;
    private String name;

    private LocalDate productionDate;

    private String color;

}

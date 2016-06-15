package pl.java.scalatech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@GenericGenerator(name="genId", strategy="increment")
public class Role extends AbstractEntity{

    private static final long serialVersionUID = -804077594557972107L;
    private String name;
    @Column(name = "roleDesc")
    private String desc;




}

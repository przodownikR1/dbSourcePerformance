package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@GenericGenerator(name="idGenerator", strategy="uuid")
public class Example {
        @Id
        @GeneratedValue(generator="idGenerator",strategy=GenerationType.AUTO)
        private String id;

        //@GeneratedValue(generator="increment")
        //@GenericGenerator(name="increment", strategy = "increment")

        private String name;

}

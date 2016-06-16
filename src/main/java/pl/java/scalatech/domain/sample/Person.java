package pl.java.scalatech.domain.sample;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import pl.java.scalatech.domain.AbstractEntity;

@Entity
@GenericGenerator(name="genId", strategy="increment")
public class Person extends AbstractEntity{

    private static final long serialVersionUID = -4161978127914686901L;

    @Column(name = "login", length = 255, nullable = false)
    private String login;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "surname", length = 255, nullable = false)
    private String surname;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)

    private Country country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="personId")
    private List<Car> cars;
}

/*

 create table Country (
        id bigint not null,
        version bigint,
        name varchar(255),
        primary key (id)
    )

create table Car (
        id bigint not null,
        version bigint,
        name varchar(255),
        personId bigint,
        primary key (id)
    )

create table Person (
id bigint not null,
version bigint,
login varchar(255) not null,
name varchar(255) not null,
surname varchar(255) not null,
country_id bigint,
primary key (id)
)

*/
package pl.java.scalatech.generator;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum GenerateType {

    FIRSTNAME("firstName",String.class),LASTNAME("lastName",String.class),AGE("age",Integer.class),EMAIL("email",String.class),STREET("street",String.class)
    ,COUNTRY("country",String.class),CITY("city",String.class)
    ,SALARY("salary",BigDecimal.class),LOGIN("login",String.class),BIRTHDATE("birthDate",LocalDate.class),NAME("name",String.class),
    ACTIVE("active",Boolean.class),DISACTIVE("disActive",Boolean.class),COLOR("color",String.class);


    private Class<?> type;
    private String fieldName;

    private GenerateType(String fieldName,Class<?> type){
        this.type = type;
        this.fieldName = fieldName;
    }

    public void setLogClass(Class<?> clazz) {
        type = clazz;
    }
}

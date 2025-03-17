package org.example.utility.JsonOps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Person {
    private String name;
    private int age;
    private String address;

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}

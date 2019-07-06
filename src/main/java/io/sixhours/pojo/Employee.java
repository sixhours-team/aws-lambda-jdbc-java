package io.sixhours.pojo;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Employee class/pojo.
 */
@Value
@AllArgsConstructor(staticName = "of")
public class Employee {

    Integer id;
    String firstName;
    String lastName;
    String address;
    String city;
}

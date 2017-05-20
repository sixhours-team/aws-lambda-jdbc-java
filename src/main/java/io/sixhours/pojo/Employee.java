package io.sixhours.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Employee class/pojo.
 *
 * @author Igor Bolic
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
}

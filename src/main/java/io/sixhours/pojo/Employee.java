package io.sixhours.pojo;

/**
 * Employee class/pojo.
 *
 * @author Igor Bolic
 */
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;

    private Employee(Integer id, String firstName, String lastName, String address, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
    }

    public static Employee of(Integer id, String firstName, String lastName, String address, String city) {
        return new Employee(id, firstName, lastName, address, city);
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}

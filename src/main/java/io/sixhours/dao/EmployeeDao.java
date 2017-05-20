package io.sixhours.dao;

import io.sixhours.pojo.Employee;

import java.util.List;

/**
 * Lambda service.
 *
 * @author Igor Bolic
 */
public interface EmployeeDao {

    List<Employee> find();
}

package io.sixhours.service;

import io.sixhours.pojo.Employee;

import java.util.List;

/**
 * Lambda service.
 *
 * @author Igor Bolic
 */
public interface EmployeeService {

    List<Employee> find();
}

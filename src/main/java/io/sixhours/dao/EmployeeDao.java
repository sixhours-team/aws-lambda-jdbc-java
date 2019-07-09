package io.sixhours.dao;

import io.sixhours.pojo.Employee;

import java.util.List;

/**
 * Employee DAO interface.
 */
public interface EmployeeDao {

    List<Employee> findAll();
}

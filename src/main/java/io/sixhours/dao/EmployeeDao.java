package io.sixhours.dao;

import io.sixhours.pojo.Employee;

import java.util.List;

/**
 * Employee DAO interface.
 *
 * @author Igor Bolic
 */
public interface EmployeeDao {

    List<Employee> findAll();
}

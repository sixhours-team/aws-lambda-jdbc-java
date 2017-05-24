package io.sixhours.dao;

import io.sixhours.db.Database;
import io.sixhours.pojo.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Default employee DAO implementation.
 *
 * @author Igor Bolic
 */
public enum DefaultEmployeeDao implements EmployeeDao {
    instance;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = Database.connection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = Employee.of(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

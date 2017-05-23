package io.sixhours;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.sixhours.dao.DefaultEmployeeDao;
import io.sixhours.dao.EmployeeDao;
import io.sixhours.pojo.Employee;

import java.util.List;

/**
 * AWS Lambda function retrieving the list of {@link Employee}s.
 *
 * @author Igor Bolic
 */
public class FindEmployeesLambda implements RequestHandler<Void, List<Employee>> {

    private final EmployeeDao employeeDao = DefaultEmployeeDao.instance;

    @Override
    public List<Employee> handleRequest(Void input, Context context) {

        return employeeDao.findAll();
    }
}

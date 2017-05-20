package io.sixhours;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.sixhours.pojo.Employee;
import io.sixhours.service.DefaultEmployeeService;
import io.sixhours.service.EmployeeService;

import java.util.List;

/**
 * Database AWS Lambda function.
 *
 * @author Igor Bolic
 */
public class DatabaseLambda implements RequestHandler<Void, List<Employee>> {

    private final EmployeeService employeeService = DefaultEmployeeService.instance();

    @Override
    public List<Employee> handleRequest(Void input, Context context) {

        List<Employee> result = employeeService.find();

        return result;
    }
}

package io.sixhours;

import com.amazonaws.services.lambda.runtime.Context;
import io.sixhours.pojo.Employee;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Lambda handler tests.
 *
 * @author Igor Bolic
 */
public class FindEmployeesLambdaTest {

    private final Void input = null;
    private final Context context = new TestContext();

    @Test
    public void thatHandleRequestReturnsResult() {
        final FindEmployeesLambda handler = new FindEmployeesLambda();

        final List<Employee> list = handler.handleRequest(input, context);

        assertThat(list, notNullValue());
    }

}
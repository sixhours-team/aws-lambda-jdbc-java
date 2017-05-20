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
public class DatabaseLambdaTest {

    private final Void input = null;
    private final Context context = new TestContext();

    @Test
    public void thatHandleRequestReturnsResult() throws Exception {
        DatabaseLambda handler = new DatabaseLambda();

        List<Employee> list = handler.handleRequest(input, context);

        assertThat(list, notNullValue());
    }

}
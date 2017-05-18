package io.sixhours;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.sixhours.service.DefaultLambdaService;
import io.sixhours.service.LambdaService;

/**
 * Database AWS Lambda function.
 *
 * @author Igor Bolic
 */
public class DatabaseLambda implements RequestHandler<Void, Boolean> {

    private final LambdaService lambdaService = DefaultLambdaService.instance();

    @Override
    public Boolean handleRequest(Void input, Context context) {

        lambdaService.find();

        return Boolean.TRUE;
    }
}

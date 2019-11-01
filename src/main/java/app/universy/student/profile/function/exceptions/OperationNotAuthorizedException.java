package app.universy.student.profile.function.exceptions;

import app.universy.lambda.apigw.exceptions.APIException;

import java.net.HttpURLConnection;

public class OperationNotAuthorizedException extends APIException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The operation is not authorized.";

    public OperationNotAuthorizedException() {
        super(ERROR_MESSAGE_TEMPLATE, HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

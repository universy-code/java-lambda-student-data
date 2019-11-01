package app.universy.student.profile.function.transformers.exceptions;

import app.universy.lambda.apigw.exceptions.APIException;

import java.net.HttpURLConnection;

public class MissingAttributesException extends APIException {

    private static final String ERROR_MESSAGE = "There are missing attributes in cognito user pool for the user.";

    public MissingAttributesException() {
        super(ERROR_MESSAGE, HttpURLConnection.HTTP_NOT_ACCEPTABLE);
    }
}

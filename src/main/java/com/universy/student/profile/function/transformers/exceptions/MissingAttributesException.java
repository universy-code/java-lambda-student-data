package com.universy.student.profile.function.transformers.exceptions;

import com.universy.lambda.api.handlers.exceptions.BusinessException;

import java.net.HttpURLConnection;

public class MissingAttributesException extends BusinessException {

    private static final String ERROR_MESSAGE = "There are missing attributes in cognito user pool for the user.";

    public MissingAttributesException() {
        super(ERROR_MESSAGE, HttpURLConnection.HTTP_NOT_ACCEPTABLE);
    }
}

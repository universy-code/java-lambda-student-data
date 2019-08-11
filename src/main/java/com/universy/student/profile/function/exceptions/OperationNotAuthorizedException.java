package com.universy.student.profile.function.exceptions;

import com.universy.lambda.api.handlers.exceptions.BusinessException;

import java.net.HttpURLConnection;

public class OperationNotAuthorizedException extends BusinessException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The operation is not authorized.";

    public OperationNotAuthorizedException() {
        super(ERROR_MESSAGE_TEMPLATE, HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

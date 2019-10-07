package com.universy.student.profile.function.extractor.exceptions;

import com.universy.lambda.api.handlers.exceptions.APIException;

import java.net.HttpURLConnection;

public class NoAccessTokenFoundException extends APIException {

    private static final String ERROR_MESSAGE = "No token found.";

    public NoAccessTokenFoundException() {
        super(ERROR_MESSAGE, HttpURLConnection.HTTP_FORBIDDEN);
    }
}

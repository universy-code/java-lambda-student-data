package com.universy.student.profile.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;

import java.net.HttpURLConnection;

public class StudentAliasFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student alias has wrong format: '%s'.";

    public StudentAliasFormatException(String alias){
        super(String.format(ERROR_MESSAGE_TEMPLATE, alias),
                HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

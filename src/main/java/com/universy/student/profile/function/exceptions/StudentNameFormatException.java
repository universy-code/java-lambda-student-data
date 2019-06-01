package com.universy.student.profile.function.exceptions;

import com.universy.lambda.api.handlers.exceptions.StatusCodeTypeException;

import java.net.HttpURLConnection;

public class StudentNameFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student name has wrong format: '%s'.";

    public StudentNameFormatException(String name){
        super(String.format(ERROR_MESSAGE_TEMPLATE, name),
                HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

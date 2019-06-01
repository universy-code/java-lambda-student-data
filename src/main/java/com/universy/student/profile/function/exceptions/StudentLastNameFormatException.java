package com.universy.student.profile.function.exceptions;

import com.universy.lambda.api.handlers.exceptions.StatusCodeTypeException;

import java.net.HttpURLConnection;

public class StudentLastNameFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student last name has wrong format: '%s'.";

    public StudentLastNameFormatException(String lastName){
        super(String.format(ERROR_MESSAGE_TEMPLATE, lastName),
                HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

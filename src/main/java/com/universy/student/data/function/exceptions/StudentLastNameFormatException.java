package com.universy.student.data.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;
import com.universy.student.data.model.StudentKey;

import java.net.HttpURLConnection;

public class StudentLastNameFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student´s last name has wrong format: '%s'.";

    public StudentLastNameFormatException(String lastName){
        super(String.format(ERROR_MESSAGE_TEMPLATE, lastName),
                HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

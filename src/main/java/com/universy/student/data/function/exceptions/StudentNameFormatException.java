package com.universy.student.data.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;
import com.universy.student.data.model.StudentKey;

import java.net.HttpURLConnection;

public class StudentNameFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student´s name has wrong format: '%s'.";

    public StudentNameFormatException(String name){
        super(String.format(ERROR_MESSAGE_TEMPLATE, name),
                HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

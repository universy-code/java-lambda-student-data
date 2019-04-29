package com.universy.student.data.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;
import com.universy.student.data.model.StudentKey;

import java.net.HttpURLConnection;

public class StudentLastNameFormatException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student '%s' does not exist.";

    public StudentLastNameFormatException(StudentKey studentKey){
        this(String.format(ERROR_MESSAGE_TEMPLATE, studentKey.getMail()));
    }


    public StudentLastNameFormatException(String s) {
        super(s, HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

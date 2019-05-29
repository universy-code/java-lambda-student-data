package com.universy.student.profile.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;
import com.universy.student.profile.model.StudentKey;

import java.net.HttpURLConnection;

public class StudentNotFoundException extends StatusCodeTypeException {

    private static final String ERROR_MESSAGE_TEMPLATE = "The student '%s' does not exist.";

    public StudentNotFoundException(StudentKey studentKey){
        this(String.format(ERROR_MESSAGE_TEMPLATE, studentKey.getMail()));
    }


    public StudentNotFoundException(String s) {
        super(s, HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

package com.universy.student.data.function.exceptions;

import com.universy.common.lambda.api.exceptions.StatusCodeTypeException;

import java.net.HttpURLConnection;

public class StudentNotFoundException extends StatusCodeTypeException {

    public StudentNotFoundException(String s) {
        super(s, HttpURLConnection.HTTP_BAD_REQUEST);
    }
}

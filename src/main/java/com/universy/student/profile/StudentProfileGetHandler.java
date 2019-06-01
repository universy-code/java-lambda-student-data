package com.universy.student.profile;

import com.universy.lambda.api.handlers.handler.BaseAPIGatewayQueryParamsHandler;
import com.universy.student.profile.function.StudentProfileGetFunction;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;

public class StudentProfileGetHandler extends BaseAPIGatewayQueryParamsHandler<StudentKey, Student, StudentProfileGetFunction> {

    @Override
    protected Class<StudentProfileGetFunction> getFunctionClass() {
        return StudentProfileGetFunction.class;
    }

    @Override
    protected Class<StudentKey> getInputClass() {
        return StudentKey.class;
    }

    @Override
    protected Class<Student> getOutputClass() {
        return Student.class;
    }
}

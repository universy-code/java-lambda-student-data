package com.universy.student.profile;

import com.universy.common.lambda.api.handler.BaseAPIGatewayBodyHandler;
import com.universy.student.profile.function.StudentProfilePutFunction;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;

public class StudentProfilePutHandler extends BaseAPIGatewayBodyHandler<Student, StudentKey, StudentProfilePutFunction> {

    @Override
    protected Class<StudentProfilePutFunction> getFunctionClass() {
        return StudentProfilePutFunction.class;
    }

    @Override
    protected Class<Student> getInputClass() {
        return Student.class;
    }

    @Override
    protected Class<StudentKey> getOutputClass() {
        return StudentKey.class;
    }
}

package com.universy.student.data;

import com.universy.common.lambda.api.handler.BaseAPIGatewayBodyHandler;
import com.universy.student.data.function.StudentWriterFunction;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;

public class WriterHandler extends BaseAPIGatewayBodyHandler<Student, StudentKey, StudentWriterFunction> {

    @Override
    protected Class<StudentWriterFunction> getFunctionClass() {
        return StudentWriterFunction.class;
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

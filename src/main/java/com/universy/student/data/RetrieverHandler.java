package com.universy.student.data;

import com.universy.common.lambda.api.handler.BaseAPIGatewayQueryParamsHandler;
import com.universy.student.data.function.StudentRetrieverFunction;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;

public class RetrieverHandler extends BaseAPIGatewayQueryParamsHandler<StudentKey, Student, StudentRetrieverFunction> {

    @Override
    protected Class<StudentRetrieverFunction> getFunctionClass() {
        return StudentRetrieverFunction.class;
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

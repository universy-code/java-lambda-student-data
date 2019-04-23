package com.universy.student.data;

import com.universy.common.lambda.api.handler.BaseAPIGatewayBodyHandler;
import com.universy.student.data.function.StudentDataWriterFunction;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentKey;

public class WriterHandler extends BaseAPIGatewayBodyHandler<StudentData, StudentKey, StudentDataWriterFunction> {

    @Override
    protected Class<StudentDataWriterFunction> getFunctionClass() {
        return StudentDataWriterFunction.class;
    }

    @Override
    protected Class<StudentData> getInputClass() {
        return StudentData.class;
    }

    @Override
    protected Class<StudentKey> getOutputClass() {
        return StudentKey.class;
    }
}

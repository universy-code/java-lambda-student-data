package com.universy.student.data;

import com.universy.common.lambda.api.handler.BaseAPIGatewayQueryParamsHandler;
import com.universy.student.data.function.StudentDataRetrieverFunction;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentKey;

public class RetrieverHandler extends BaseAPIGatewayQueryParamsHandler<StudentKey, StudentData, StudentDataRetrieverFunction> {

    @Override
    protected Class<StudentDataRetrieverFunction> getFunctionClass() {
        return StudentDataRetrieverFunction.class;
    }

    @Override
    protected Class<StudentKey> getInputClass() {
        return StudentKey.class;
    }

    @Override
    protected Class<StudentData> getOutputClass() {
        return StudentData.class;
    }
}

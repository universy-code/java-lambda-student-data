package com.universy.student.data;

import com.universy.common.lambda.api.handler.BaseAPIGatewayQueryParamsHandler;
import com.universy.student.data.function.StudentDataRetrieverFunction;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentDataRequest;

public class RetrieverHandler extends BaseAPIGatewayQueryParamsHandler<StudentDataRequest, StudentData, StudentDataRetrieverFunction> {

    public RetrieverHandler() {
        super(StudentDataRequest.class, StudentData.class, StudentDataRetrieverFunction.class);
    }

}

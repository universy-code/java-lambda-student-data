package com.universy.student.profile;

import com.universy.lambda.api.handlers.handler.apigateway.supplier.SupplierHandler;
import com.universy.student.profile.function.StudentProfileGetSupplier;
import com.universy.student.profile.model.Student;

import java.util.function.Supplier;

public class StudentProfileGetHandler extends SupplierHandler<Student> {

    @Override
    protected Supplier<Student> getSupplier() {
        return new StudentProfileGetSupplier();
    }

}

package com.universy.student.profile;

import com.universy.lambda.api.handlers.handler.apigateway.consumer.ConsumerHandler;
import com.universy.student.profile.function.StudentProfilePostConsumer;
import com.universy.student.profile.model.Student;

import java.util.function.Consumer;

public class StudentProfilePostHandler extends ConsumerHandler<Student> {

    @Override
    protected Consumer<Student> getConsumer() {
        return new StudentProfilePostConsumer();
    }

    @Override
    protected Class<Student> getInputClass() {
        return Student.class;
    }
}

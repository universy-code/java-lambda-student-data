package com.universy.student.profile.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.profile.function.exceptions.StudentNotFoundException;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.function.Function;

public class StudentProfileGetFunction implements Function<StudentKey, Student> {

    private static Logger LOGGER = LogManager.getLogger(StudentProfileGetFunction.class);

    @Override
    public Student apply(StudentKey studentKey) {

        LOGGER.info("Received student to get data:" + studentKey);

        Optional<Student> student = getStudentFromDataBase(studentKey);

        if (student.isPresent()) {
            LOGGER.info("The student is present in the database.");
            return student.get();
        } else {
            LOGGER.info("The student is not present in the database.");
            throw new StudentNotFoundException(studentKey);
        }
    }

    private Optional<Student> getStudentFromDataBase(StudentKey studentKey){
        DynamoDBMapper mapper = DynamoDBMapperFactory.createMapper();
        return Optional.ofNullable(mapper.load(Student.class, studentKey));
    }
}




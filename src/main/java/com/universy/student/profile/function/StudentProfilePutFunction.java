package com.universy.student.profile.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.profile.function.validator.StudentValidator;
import com.universy.student.profile.function.validator.Validator;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class StudentProfilePutFunction implements Function<Student, StudentKey> {

    private static Logger LOGGER = LogManager.getLogger(StudentProfilePutFunction.class);

    @Override
    public StudentKey apply(Student student) {
        LOGGER.info("Received student data to store: {}.", student.getStudentKey());

        Validator studentValidator = new StudentValidator(student);
        studentValidator.validate();

        return storeStudentInDataBase(student);
    }

    private StudentKey storeStudentInDataBase(Student student){
        DynamoDBMapper mapper = DynamoDBMapperFactory.createMapper();
        mapper.save(student);
        LOGGER.info("Student saved successfully to database. {}.", student.getStudentKey());
        return student.getStudentKey();
    }
}

package com.universy.student.data.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.data.function.exceptions.StudentNotFoundException;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.function.Function;

public class StudentDataRetrieverFunction implements Function<StudentKey, StudentData> {

    private static Logger LOGGER = LogManager.getLogger(StudentDataRetrieverFunction.class);

    @Override
    public StudentData apply(StudentKey studentKey) {

        LOGGER.info("Received student to get data:" + studentKey);

        Optional<StudentData> studentData = getStudentFromDataBase(studentKey);

        if (studentData.isPresent()) {
            LOGGER.info("The student is present in the database.");
            return studentData.get();
        } else {
            LOGGER.info("The student is not present in the database.");
            throw new StudentNotFoundException(studentKey);
        }
    }

    private Optional<StudentData> getStudentFromDataBase(StudentKey studentKey){
        DynamoDBMapper mapper = DynamoDBMapperFactory.createMapper();
        return Optional.ofNullable(mapper.load(StudentData.class, studentKey));
    }
}




package com.universy.student.data.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class StudentDataWriterFunction implements Function<StudentData, StudentKey> {

    private static Logger LOGGER = LogManager.getLogger(StudentDataRetrieverFunction.class);

    @Override
    public StudentKey apply(StudentData studentData) {
        LOGGER.info("Received student data to store: {}.", studentData.getStudentKey());
        return storeStudentInDataBase(studentData);
    }

    private StudentKey storeStudentInDataBase(StudentData studentData){
        DynamoDBMapper mapper = DynamoDBMapperFactory.createMapper();
        mapper.save(studentData);
        LOGGER.info("Student saved successfully to database. {}.", studentData.getStudentKey());
        return studentData.getStudentKey();
    }

}

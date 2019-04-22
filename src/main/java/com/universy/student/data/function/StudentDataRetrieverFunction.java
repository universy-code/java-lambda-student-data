package com.universy.student.data.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.data.function.exceptions.MailFormatException;
import com.universy.student.data.function.exceptions.StudentNotFoundException;
import com.universy.student.data.model.StudentData;
import com.universy.student.data.model.StudentDataRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.function.Function;

public class StudentDataRetrieverFunction implements Function<StudentDataRequest, StudentData> {

    private static Logger LOGGER = LogManager.getLogger(StudentDataRetrieverFunction.class);

    @Override
    public StudentData apply(StudentDataRequest studentDataRequest) {

        LOGGER.info("Recieved request:" + studentDataRequest);

        String studentMail = studentDataRequest.getMail();

        if(studentMail.matches("^\\w+@[a-zA-Z_]+?(\\.[a-zA-Z]{1,3})+")){
            LOGGER.info("The mail is present");

            DynamoDBMapper mapper = DynamoDBMapperFactory.createMapper();
            Optional<StudentData> studentData = Optional.ofNullable(mapper.load(StudentData.class, studentMail));

            if(studentData.isPresent()){
                LOGGER.info("The student is present");
                return studentData.get();
            } else {
                throw new StudentNotFoundException(String.format("The student '%s' does not exist.", studentMail));
            }
        } else {
            throw new MailFormatException("Mail has incorrect format: " + studentMail);
        }
    }



}

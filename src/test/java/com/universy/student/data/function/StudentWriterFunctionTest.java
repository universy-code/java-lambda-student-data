package com.universy.student.data.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.data.function.exceptions.StudentNotFoundException;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DynamoDBMapperFactory.class)
@PowerMockIgnore("javax.management.*")
public class StudentWriterFunctionTest {

    private static final String MOCK_MAIL = "mail@example.com";

    private DynamoDBMapper mapper;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(DynamoDBMapperFactory.class);
        mapper = Mockito.mock(DynamoDBMapper.class);
        Mockito.when(DynamoDBMapperFactory.createMapper()).thenReturn(mapper);
    }

    @Test
    public void studentExistsInDB() {
        StudentKey studentKey = new StudentKey(MOCK_MAIL);

        Student student = new Student();
        student.setStudentKey(studentKey);

        Function<Student, StudentKey> function = new StudentWriterFunction();
        StudentKey retrievedKey = function.apply(student);

        ArgumentCaptor<Student> studentCapture = ArgumentCaptor.forClass(Student.class);
        Mockito.verify(mapper, Mockito.times(1))
                .save(studentCapture.capture());

        assertEquals(studentKey, retrievedKey);
        assertEquals(student, studentCapture.getValue());

    }
}

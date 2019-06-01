package com.universy.student.profile.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.universy.common.dynamo.DynamoDBMapperFactory;
import com.universy.student.profile.function.exceptions.StudentNotFoundException;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class StudentProfileGetFunctionTest {

    private static final String MOCK_MAIL = "mail@example.com";

    private DynamoDBMapper mapper;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(DynamoDBMapperFactory.class);
        mapper = Mockito.mock(DynamoDBMapper.class);
        Mockito.when(DynamoDBMapperFactory.createMapper()).thenReturn(mapper);
    }

    @Test
    public void studentExistsInDB(){
        StudentKey studentKey = new StudentKey(MOCK_MAIL);

        Student student = new Student();
        student.setStudentKey(studentKey);

        Mockito.when(mapper.load(eq(Student.class), any(StudentKey.class)))
                .thenReturn(student);

        Function<StudentKey, Student> function = new StudentProfileGetFunction();
        Student retrievedData = function.apply(studentKey);
        assertEquals(student.getStudentKey(), retrievedData.getStudentKey());

    }

    @Test(expected = StudentNotFoundException.class)
    public void studentDoesNotExistsInDB(){
        StudentKey studentKey = new StudentKey(MOCK_MAIL);

        Mockito.when(mapper.load(eq(Student.class), any(StudentKey.class)))
                .thenReturn(null);

        Function<StudentKey, Student> function = new StudentProfileGetFunction();
        function.apply(studentKey);
    }
}

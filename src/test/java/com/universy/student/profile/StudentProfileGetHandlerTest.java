package com.universy.student.profile;

import com.universy.student.profile.function.StudentProfileGetFunction;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentProfileGetHandlerTest {

    private StudentProfileGetHandler handler;

    @Before
    public void setUp() {
        handler = new StudentProfileGetHandler();
    }

    @Test
    public void testReturnedTypes() {
        assertEquals(StudentKey.class, handler.getInputClass());
        assertEquals(Student.class, handler.getOutputClass());
        assertEquals(StudentProfileGetFunction.class, handler.getFunctionClass());
    }
}

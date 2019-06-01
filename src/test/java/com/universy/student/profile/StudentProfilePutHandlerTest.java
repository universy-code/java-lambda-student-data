package com.universy.student.profile;

import com.universy.student.profile.function.StudentProfilePutFunction;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentProfilePutHandlerTest {

    private StudentProfilePutHandler handler;

    @Before
    public void setUp() {
        handler = new StudentProfilePutHandler();
    }

    @Test
    public void testReturnedTypes() {
        assertEquals(Student.class, handler.getInputClass());
        assertEquals(StudentKey.class, handler.getOutputClass());
        assertEquals(StudentProfilePutFunction.class, handler.getFunctionClass());
    }
}

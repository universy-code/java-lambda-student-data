package com.universy.student.data;

import com.universy.student.data.function.StudentWriterFunction;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WriterHandlerTest {

    private WriterHandler handler;

    @Before
    public void setUp() {
        handler = new WriterHandler();
    }

    @Test
    public void testReturnedTypes() {
        assertEquals(Student.class, handler.getInputClass());
        assertEquals(StudentKey.class, handler.getOutputClass());
        assertEquals(StudentWriterFunction.class, handler.getFunctionClass());
    }
}

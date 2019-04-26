package com.universy.student.data;

import com.universy.student.data.function.StudentRetrieverFunction;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RetrieverHandlerTest {

    private RetrieverHandler handler;

    @Before
    public void setUp() {
        handler = new RetrieverHandler();
    }

    @Test
    public void testReturnedTypes() {
        assertEquals(StudentKey.class, handler.getInputClass());
        assertEquals(Student.class, handler.getOutputClass());
        assertEquals(StudentRetrieverFunction.class, handler.getFunctionClass());
    }
}

package com.universy.student.profile.model.converters;

import com.universy.student.profile.model.StudentKey;
import com.universy.student.profile.model.converters.exceptions.MailFormatException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentKeyConverterTest {

    private static final String CORRECT_MAIL = "mail@example.com";
    private static final String INCORRECT_MAIL = "mail_xample.com";

    private StudentKeyConverter converter;

    @Before
    public void setUp() {
        converter = new StudentKeyConverter();
    }

    @Test
    public void convertCorrectMailTest() {
        StudentKey studentKey = new StudentKey(CORRECT_MAIL);
        String convertedStudentKey = converter.convert(studentKey);
        assertEquals(CORRECT_MAIL, convertedStudentKey);
    }

    @Test(expected = MailFormatException.class)
    public void convertIncorrectMailTest() {
        StudentKey studentKey = new StudentKey(INCORRECT_MAIL);
        converter.convert(studentKey);
    }

    @Test
    public void unconvertCorrectMailTest() {
        StudentKey studentKey = converter.unconvert(CORRECT_MAIL);
        assertEquals(CORRECT_MAIL, studentKey.getMail());
    }

    @Test(expected = MailFormatException.class)
    public void unconvertIncorrectMailTest() {
        converter.unconvert(INCORRECT_MAIL);
    }
}
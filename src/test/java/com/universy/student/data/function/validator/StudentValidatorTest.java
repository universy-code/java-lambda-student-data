package com.universy.student.data.function.validator;

import com.universy.student.data.function.exceptions.StudentLastNameFormatException;
import com.universy.student.data.function.exceptions.StudentNameFormatException;
import com.universy.student.data.model.Student;
import com.universy.student.data.model.StudentKey;
import org.junit.Test;

public class StudentValidatorTest {

    private static final String CORRECT_NAME = "Example Name";
    private static final String CORRECT_LASTNAME = "Example LastName";
    private static final String INCORRECT_NAME = " ";
    private static final String INCORRECT_LASTNAME = " ";
    private static final Student CORRECT_STUDENT = new Student();
    private static final Student INCORRECT_STUDENT = new Student();
    private static final StudentKey STUDENT_KEY = new StudentKey("new_email@example.com");

    private Validator studentValidator;

    @Test()
    public void studentValid(){
        CORRECT_STUDENT.setName(CORRECT_NAME);
        CORRECT_STUDENT.setLastName(CORRECT_LASTNAME);
        CORRECT_STUDENT.setStudentKey(STUDENT_KEY);
        studentValidator = new StudentValidator(CORRECT_STUDENT);
        studentValidator.validate();
    }

    @Test(expected = StudentNameFormatException.class)
    public void nameNotValid(){
        INCORRECT_STUDENT.setName(INCORRECT_NAME);
        INCORRECT_STUDENT.setLastName(CORRECT_LASTNAME);
        INCORRECT_STUDENT.setStudentKey(STUDENT_KEY);
        studentValidator = new StudentValidator(INCORRECT_STUDENT);
        studentValidator.validate();
    }

    @Test(expected = StudentLastNameFormatException.class)
    public void lastNameNotValid(){
        INCORRECT_STUDENT.setName(CORRECT_NAME);
        INCORRECT_STUDENT.setLastName(INCORRECT_LASTNAME);
        INCORRECT_STUDENT.setStudentKey(STUDENT_KEY);
        studentValidator = new StudentValidator(INCORRECT_STUDENT);
        studentValidator.validate();
    }
}

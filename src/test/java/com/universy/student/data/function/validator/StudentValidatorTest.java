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
    private static final StudentKey STUDENT_KEY = new StudentKey("new_email@example.com");

    private Validator studentValidator;

    @Test
    public void studentValid(){

        Student student = createStudent(CORRECT_NAME, CORRECT_LASTNAME, STUDENT_KEY);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    @Test(expected = StudentNameFormatException.class)
    public void nameNotValid(){

        Student student = createStudent(INCORRECT_NAME, CORRECT_LASTNAME, STUDENT_KEY);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    @Test(expected = StudentLastNameFormatException.class)
    public void lastNameNotValid(){

        Student student = createStudent(CORRECT_NAME, INCORRECT_LASTNAME, STUDENT_KEY);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    private Student createStudent(String name, String lastName, StudentKey key){

        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setStudentKey(key);
        return student;
    }
}

package com.universy.student.profile.function.validator;

import com.universy.student.profile.function.exceptions.StudentAliasFormatException;
import com.universy.student.profile.function.exceptions.StudentLastNameFormatException;
import com.universy.student.profile.function.exceptions.StudentNameFormatException;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.StudentKey;
import org.junit.Test;

public class StudentValidatorTest {

    private static final String CORRECT_NAME = "Example Name";
    private static final String CORRECT_LAST_NAME = "Example LastName";
    private static final String CORRECT_ALIAS = "Example Alias";
    private static final String INCORRECT_NAME = " ";
    private static final String INCORRECT_LAST_NAME = " ";
    private static final String INCORRECT_ALIAS = " ";
    private static final StudentKey STUDENT_KEY = new StudentKey("new_email@example.com");

    private Validator studentValidator;

    @Test
    public void studentValid(){
        Student student = createStudent(STUDENT_KEY, CORRECT_NAME, CORRECT_LAST_NAME, CORRECT_ALIAS);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    @Test(expected = StudentNameFormatException.class)
    public void nameNotValid(){
        Student student = createStudent(STUDENT_KEY, INCORRECT_NAME, CORRECT_LAST_NAME, CORRECT_ALIAS);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    @Test(expected = StudentLastNameFormatException.class)
    public void lastNameNotValid(){
        Student student = createStudent(STUDENT_KEY, CORRECT_NAME, INCORRECT_LAST_NAME, CORRECT_ALIAS);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    @Test(expected = StudentAliasFormatException.class)
    public void aliasNotValid(){
        Student student = createStudent(STUDENT_KEY, CORRECT_NAME, CORRECT_LAST_NAME, INCORRECT_ALIAS);
        studentValidator = new StudentValidator(student);
        studentValidator.validate();
    }

    private Student createStudent(StudentKey key, String name, String lastName, String alias){
        Student student = new Student();
        student.setStudentKey(key);
        student.setName(name);
        student.setLastName(lastName);
        student.setAlias(alias);
        return student;
    }
}

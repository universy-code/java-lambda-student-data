package com.universy.student.data.function.validator;

import com.universy.student.data.function.exceptions.StudentLastNameFormatException;
import com.universy.student.data.function.exceptions.StudentNameFormatException;
import com.universy.student.data.model.Student;

public class StudentValidator implements Validator {
    private final Student student;

    public StudentValidator(Student student) { this.student = student; }

    @Override
    public void validate() {

        validateName();
        validateLastName();
    }

    private void validateName(){

        if(student.getName().trim().isEmpty()){
            throw new StudentNameFormatException(student.getName());
        }
    }

    private void validateLastName(){

        if(student.getLastName().trim().isEmpty()){
            throw new StudentLastNameFormatException(student.getLastName());
        }
    }
}

package com.universy.student.profile.function.validator;

import com.universy.student.profile.function.exceptions.StudentAliasFormatException;
import com.universy.student.profile.function.exceptions.StudentLastNameFormatException;
import com.universy.student.profile.function.exceptions.StudentNameFormatException;
import com.universy.student.profile.model.Student;

public class StudentValidator implements Validator {
    private final Student student;

    public StudentValidator(Student student) { this.student = student; }

    @Override
    public void validate() {
        validateName();
        validateLastName();
        validateAlias();
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

    private void validateAlias() {
            if(student.getAlias().trim().isEmpty()){
                throw new StudentAliasFormatException(student.getAlias());
            }
    }
}

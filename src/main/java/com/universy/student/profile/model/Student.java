package com.universy.student.profile.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.universy.student.profile.model.converters.StudentKeyConverter;

import java.util.Objects;

@DynamoDBTable(tableName = "student-profile")
public class Student {

    @DynamoDBHashKey
    @DynamoDBTypeConverted(converter = StudentKeyConverter.class)
    private StudentKey studentKey;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String lastName;

    @DynamoDBAttribute
    private String alias;

    public StudentKey getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(StudentKey studentKey) {
        this.studentKey = studentKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentKey, student.studentKey) &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(alias, student.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentKey, name, lastName, alias);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentKey=" + studentKey +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}

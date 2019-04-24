package com.universy.student.data.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.universy.student.data.model.converters.StudentKeyConverter;

import java.util.Objects;

@DynamoDBTable(tableName = "student-data")
public class Student {

    @DynamoDBHashKey
    @DynamoDBTypeConverted(converter = StudentKeyConverter.class)
    private StudentKey studentKey;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String lastName;

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

    @Override
    public String toString() {
        return "Student{" +
                "studentKey='" + studentKey + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(studentKey, that.studentKey) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentKey, name, lastName);
    }
}

package com.universy.student.data.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.universy.student.data.model.converters.StudentKeyConverter;

@DynamoDBTable(tableName = "student-data")
public class StudentData {

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
        return "StudentData{" +
                "studentKey='" + studentKey + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

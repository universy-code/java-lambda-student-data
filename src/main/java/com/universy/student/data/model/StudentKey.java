package com.universy.student.data.model;


public class StudentKey {

    private String mail;

    public StudentKey() {
    }

    public StudentKey(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "StudentKey{" +
                "mail='" + mail + '\'' +
                '}';
    }
}

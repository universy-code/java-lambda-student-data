package com.universy.student.data.model;


public class StudentDataRequest {
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "StudentDataRequest{" +
                "mail='" + mail + '\'' +
                '}';
    }
}

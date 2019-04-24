package com.universy.student.data.model;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentKey that = (StudentKey) o;
        return Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}

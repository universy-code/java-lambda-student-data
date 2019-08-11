package com.universy.student.profile.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    private String username;
    private String givenName;
    private String familyName;
    private String email;

    public Student(){
    }

    public Student(@JsonProperty(value = "username", required = true) String username,
                   @JsonProperty(value = "givenName", required = true) String givenName,
                   @JsonProperty(value = "familyName", required = true) String familyName,
                   @JsonProperty(value = "email", required = true) String email) {
        this.username = username;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

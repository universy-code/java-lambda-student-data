package com.universy.student.profile.model;

public class UpdateAttributesParameters {
    private String accessToken;
    private String givenName;
    private String familyName;
    private String email;

    public UpdateAttributesParameters(String accessToken, String givenName, String familyName, String email) {
        this.accessToken = accessToken;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }
}

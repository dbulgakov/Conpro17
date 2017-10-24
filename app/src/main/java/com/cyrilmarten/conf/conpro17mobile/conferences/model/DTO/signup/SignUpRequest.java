package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest {
    @SerializedName("login")
    private final String userEmail;

    @SerializedName("password")
    private final String userPassword;

    public SignUpRequest(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}

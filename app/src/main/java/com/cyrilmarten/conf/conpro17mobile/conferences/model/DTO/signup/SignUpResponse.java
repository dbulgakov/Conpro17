package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {
    @SerializedName("user_id")
    private final int userId;

    @SerializedName("user_active")
    private final boolean userActive;

    @SerializedName("status_code")
    private final int statusCode;
    @SerializedName("AuthorizationResult")
    private String token;

    public SignUpResponse(int userId, boolean userActive, int statusCode) {
        this.userId = userId;
        this.userActive = userActive;
        this.statusCode = statusCode;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

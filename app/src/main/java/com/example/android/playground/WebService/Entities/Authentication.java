package com.example.android.playground.WebService.Entities;

import com.google.gson.annotations.SerializedName;

public class Authentication {

    @SerializedName("success")
    private String mSuccess;

    @SerializedName("expires_at")
    private String mExpiration;

    @SerializedName("request_token")
    private String mRequestToken;

    public String getSuccess() {
        return mSuccess;
    }

    public String getExpiration() {
        return mExpiration;
    }

    public String getRequestToken() {
        return mRequestToken;
    }


}

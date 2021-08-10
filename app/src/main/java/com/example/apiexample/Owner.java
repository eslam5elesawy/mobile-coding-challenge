package com.example.apiexample;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    private String full_name;

    @SerializedName("avatar_url")
    private String avatar_url;

    public Owner() {
    }

    public Owner(String full_name, String avatar_url) {
        this.full_name = full_name;
        this.avatar_url = avatar_url;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}

package com.example.apiexample;


import com.google.gson.annotations.SerializedName;

public class item {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;


    @SerializedName("stargazers_count")
    private String stargazers_count;

    @SerializedName("owner")
    private Owner owner;

    public item() {
    }

    public item(String repo_name, String repo_description, String owner_name, String owner_avatar, String stars, Owner owner) {
        name = repo_name;
        description = repo_description;
        this.stargazers_count = stars;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(String stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

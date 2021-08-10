package com.example.apiexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemList {

    @SerializedName("items")
    private List<item> items;

    public ItemList(List<item> items) {
        this.items = items;
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }
}

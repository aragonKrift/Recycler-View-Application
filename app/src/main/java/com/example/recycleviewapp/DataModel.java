package com.example.recycleviewapp;

public class DataModel {

    private final String name;
    private final String description;
    private final int image;
    private final int id_;

    public DataModel(String name, String description, int image, int id_) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id_ = id_;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getId_() {
        return id_;
    }
}

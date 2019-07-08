package com.harpreet.notes_app.Modal;

public class Data {

    private String name;
    private  String description;
    private String id;
    private  String date;

    public  Data()
    {}

    public Data(String name, String description, String id, String date) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String data) {
        this.date = date;
    }
}

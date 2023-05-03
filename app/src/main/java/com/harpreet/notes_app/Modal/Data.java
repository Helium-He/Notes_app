package com.harpreet.notes_app.Modal;

public class Data {

    //attrubutes of the "Notes" object
    private String name;
    private  String description;
    private String id;
    private  String date;

    //empty constructor
    public  Data()
    {}

    //constructor for "Note" object
    public Data(String name, String description, String id, String date) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    //returns this name/title of the note
    //@return the name/title
    public String getName() {
        return name;
    }

    //returns the description thats related to the notes name/title
    //@return the description of the notes name/title
    public String getDescription() {
        return description;
    }

    //returns the ID thats related to the note created
    //@return the ID of the notes created
    public String getId() {
        return id;
    }

    //returns the Date thats related to the note created
    //@return the Date of the notes created
    public String getDate() {
        return date;
    }

    //this sets the name of the note based on the user input field
    //@param: the name for which what the notes title should be
    public void setName(String name) {
        this.name = name;
    }

    //this sets the description of the notes related to the title/name based on what the user input field
    //@param: the description of the contents that is related to the name/title of the note
    public void setDescription(String description) {
        this.description = description;
    }

    //this sets the ID of the note when it is created automatically
    //@param: the ID for which what the note created will be
    public void setId(String id) {
        this.id = id;
    }

    //this sets the Date of the note when it is created automatically
    //@param: the Date for which what the note created will be
    public void setDate(String data) {
        this.date = date;
    }
}

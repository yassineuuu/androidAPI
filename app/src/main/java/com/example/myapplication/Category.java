package com.example.myapplication;

public class Category {

    private long id;

    private String Category;
    private String discription;


    public Category() {
    }


    public Category(long id, String category, String discription) {
        this.id = id;
        Category = category;
        this.discription = discription;
    }


    public Category(String category, String discription) {
        Category = category;
        this.discription = discription;
    }


    public String getDiscription() {
        return discription;
    }


    public void setDiscription(String discription) {
        this.discription = discription;
    }




    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }



}

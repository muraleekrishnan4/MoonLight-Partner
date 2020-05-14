package com.example.moonlightpartner;


public class Product {


    String foodID;
    String title;
    String description;
    double price;
    boolean selected;


    public Product(String foodID, String title, String description, double price) {
        this.foodID = foodID;
        this.title = title;
        this.description = description;
        this.price = price;
    }


    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSelected() {
        return selected;
    }

}
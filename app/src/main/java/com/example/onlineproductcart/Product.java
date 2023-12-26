package com.example.onlineproductcart;

public class Product {
    int id;
    String image;
    String name;
    String details;
    double price;

    public Product(int id, String image, String name, String details, double price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.details = details;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public double getPrice() {
        return price;
    }
}

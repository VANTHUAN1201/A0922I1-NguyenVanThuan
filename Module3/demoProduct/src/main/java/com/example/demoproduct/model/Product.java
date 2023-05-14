package com.example.demoproduct.model;

public class Product {
    int id;
    String name;
    int price;
    int amount;
    int id_category;

    public Product() {
    }

    public Product(int id, String name, int price, int amount, int id_category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id_category = id_category;
    }

    public Product(String name, int price, int amount, int id_category ) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

}

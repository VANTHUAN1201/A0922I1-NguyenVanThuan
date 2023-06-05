package codegym.model;

import java.util.Date;

public class Product {
    int id;
    String name;
    int categoryId;
    int quantity;
    String date;
    String price;

    public Product() {
    }

    public Product(int id, String name, int categoryId, int quantity, String date, String price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.date = date;
        this.price = price;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

package io_file_binary.product;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String production;
    private int price;
    private String describe;

    public Product(int id, String name, String production, int price, String describe) {
        this.id = id;
        this.name = name;
        this.production = production;
        this.price = price;
        this.describe = describe;
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

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", production='" + production + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }
}

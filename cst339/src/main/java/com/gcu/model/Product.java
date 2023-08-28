package com.gcu.model;

public class Product {
    private long id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private boolean soldOut;
    private String imagePath;

    public Product() {
    }

    public Product(long id, String name, String description, float price, int stock, boolean soldOut,
            String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.soldOut = soldOut;
        // still not sold on this property
        // ideally we'd use an S3 bucket or something
        // for a large number of items with multiple
        // pictures with the name being <product id><img num.>.<img ext>
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}

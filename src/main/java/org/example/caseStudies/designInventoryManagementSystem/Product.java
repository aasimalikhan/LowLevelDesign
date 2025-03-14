package org.example.caseStudies.designInventoryManagementSystem;

public class Product {
    private static int idCounter = 101;
    private String id;
    private int stock;
    private double price;
    private String brand;
    private String color;

    public String getId()
    {
        return this.id;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable()
    {
        return this.stock > 0;
    }

    public Product(int stock, int price, String brand, String color)
    {
        this.id = String.valueOf(idCounter++);
        this.stock = stock;
        this.price = price;
        this.brand = brand;
        this.color = color;
    }

}

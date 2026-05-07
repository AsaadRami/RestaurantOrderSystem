package com.restaurant.model;
public abstract class MenuItem {
    private int id;
    private String name;
    private double price;
    public MenuItem(int id, String name, double price) {
        this.id    = id;
        this.name  = name;
        this.price = price;
    }
    public abstract String getCategory();
    public abstract String getDescription();
    public int    getId()    { return id; }
    public String getName()  { return name; }
    public double getPrice() { return price; }
    public void setId(int id)       { this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setPrice(double p)  { this.price = p; }
    @Override
    public String toString() {
        return name + " (" + getCategory() + ") - $" + String.format("%.2f", price);
    }
}

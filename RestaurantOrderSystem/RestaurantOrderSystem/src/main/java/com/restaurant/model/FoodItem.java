package com.restaurant.model;
public class FoodItem extends MenuItem {
    public FoodItem(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public String getCategory() {
        return "Food";
    }
    @Override
    public String getDescription() {
        return "Delicious food item: " + getName();
    }
}

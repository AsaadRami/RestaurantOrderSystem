package com.restaurant.model;
public class DrinkItem extends MenuItem {
    public DrinkItem(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public String getCategory() {
        return "Drink";
    }
    @Override
    public String getDescription() {
        return "Refreshing drink: " + getName();
    }
}

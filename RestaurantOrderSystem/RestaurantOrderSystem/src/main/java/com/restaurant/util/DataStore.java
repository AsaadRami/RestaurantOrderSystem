package com.restaurant.util;

import com.restaurant.model.*;

import java.util.ArrayList;
import java.util.List;
public class DataStore {
    private static DataStore instance;
    private List<User>     users     = new ArrayList<>();
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<Order>    orders    = new ArrayList<>();
    private User currentUser = null;
    private DataStore() {
        seedData();
    }
    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }
    private void seedData() {
        users.add(new User("admin", "admin123", "asaad@gmail.com", "admin"));
        users.add(new User("asaad", "asaad123", "asaad@gmail.com", "customer"));
        users.add(new User("ziad", "ziad123", "asaad@gmail.com", "customer"));
        users.add(new User("yassin", "yassin123", "asaad@gmail.com", "customer"));
        menuItems.add(new FoodItem(1, "Burger",       150));
        menuItems.add(new FoodItem(2, "Pizza",        300));
        menuItems.add(new FoodItem(3, "Pasta",        100));
        menuItems.add(new FoodItem(4, "Salad",        50));
        menuItems.add(new FoodItem(5, "Sandwich",     90));
        menuItems.add(new DrinkItem(6, "Water",       10));
        menuItems.add(new DrinkItem(7, "Juice",       60));
        menuItems.add(new DrinkItem(8, "Soda",        80));
        menuItems.add(new DrinkItem(9, "Coffee",      40));
        menuItems.add(new DrinkItem(10, "Tea",        25));
    }
    public boolean registerUser(String username, String password, String email) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password, email, "customer"));
        return true;
    }
    public User loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void saveOrder(Order order) {
        orders.add(order);
    }
    public List<Order> getOrdersByUser(String username) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getUsername().equals(username)) {
                result.add(o);
            }
        }
        return result;
    }
    public List<Order> getAllOrders() {
        return orders;
    }
    public User getCurrentUser()          { return currentUser; }
    public void setCurrentUser(User user) { this.currentUser = user; }
    public void logout()                  { this.currentUser = null; }
    public List<User> getAllUsers() { return users; }
}

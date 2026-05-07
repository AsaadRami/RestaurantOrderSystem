package com.restaurant.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class Order {
    private static int nextId = 1;
    private int orderId;
    private String username;
    private List<MenuItem> items;
    private double totalPrice;
    private String status;
    private String orderTime;
    public Order(String username) {
        this.orderId   = nextId++;
        this.username  = username;
        this.items     = new ArrayList<>();
        this.totalPrice = 0.0;
        this.status    = "Pending";
        this.orderTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public void addItem(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }
    public void clearItems() {
        items.clear();
        totalPrice = 0.0;
    }
    public int           getOrderId()    { return orderId; }
    public String        getUsername()   { return username; }
    public List<MenuItem> getItems()     { return items; }
    public double        getTotalPrice() { return totalPrice; }
    public String        getStatus()     { return status; }
    public String        getOrderTime()  { return orderTime; }
    public void setStatus(String status)         { this.status = status; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public String toNetworkString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER_ID:").append(orderId)
          .append("|USER:").append(username)
          .append("|TIME:").append(orderTime)
          .append("|ITEMS:");
        for (MenuItem item : items) {
            sb.append(item.getName()).append("(").append(item.getPrice()).append("),");
        }
        sb.append("|TOTAL:").append(String.format("%.2f", totalPrice));
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Order #" + orderId + " by " + username +
               " | Items: " + items.size() +
               " | Total: $" + String.format("%.2f", totalPrice) +
               " | Status: " + status;
    }
}

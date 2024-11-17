package com.example.personalrestaurantguide;

public class Restaurant {
    private String name;
    private String address;
    private String phone;
    private String description;
    private int rating;

    public Restaurant(String name, String address, String phone, String description, int rating) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}

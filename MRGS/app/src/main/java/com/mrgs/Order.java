package com.mrgs;

/**
 * Created by gy on 2016. 8. 3..
 */
public class Order {
    private String name;
    private String price;
    public Order(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

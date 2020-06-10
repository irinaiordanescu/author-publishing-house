package com.example.wishlist.model;

import javax.persistence.*;

@Entity
@Table(name = "wish")
public class ShoppingWishList {
    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "shopName")
    String shopName;

    public ShoppingWishList() {
    }

    public ShoppingWishList(int id, String name, String description, String shopName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shopName = shopName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}

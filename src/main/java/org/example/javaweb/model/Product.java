package org.example.javaweb.model;

import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private int price;

    @Column(name="Stock")
    private int stock;

    @Column(name = "Description")
    private String description;

    @Column(name="Category")
    private String category;

    @Column(name="Image")
    private String image;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

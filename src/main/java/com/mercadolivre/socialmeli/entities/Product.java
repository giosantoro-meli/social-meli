package com.mercadolivre.socialmeli.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product(){
    }

    public Product(String productName, String type, String brand, String color, String notes) {
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

package com.club.banyuan.shengtang.jdbc;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private int categroyLevel1Id;
    private int categroyLevel2Id;
    private int categroyLevel3Id;


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

    public int getCategroyLevel1Id() {
        return categroyLevel1Id;
    }

    public void setCategroyLevel1Id(int categroyLevel1Id) {
        this.categroyLevel1Id = categroyLevel1Id;
    }

    public int getCategroyLevel2Id() {
        return categroyLevel2Id;
    }

    public void setCategroyLevel2Id(int categroyLevel2Id) {
        this.categroyLevel2Id = categroyLevel2Id;
    }

    public int getCategroyLevel3Id() {
        return categroyLevel3Id;
    }

    public void setCategroyLevel3Id(int categroyLevel3Id) {
        this.categroyLevel3Id = categroyLevel3Id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categroyLevel1Id=" + categroyLevel1Id +
                ", categroyLevel2Id=" + categroyLevel2Id +
                ", categroyLevel3Id=" + categroyLevel3Id +
                '}';
    }
}

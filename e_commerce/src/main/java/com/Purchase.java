package com;

public class Purchase {
    private int itemId;
    private String itemName;
    private String category;
    private int quantity;
    private double price;
    private java.sql.Date purchaseDate;
    private String supplier;

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPurchaseDate(java.sql.Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public java.sql.Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getSupplier() {
        return supplier;
    }
}
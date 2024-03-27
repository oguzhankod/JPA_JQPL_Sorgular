package org.example.entities;

public class ProductDetails {

    private String productName;
    private double unitPrice;
    private int stock;
    private String brandName;
    private String categoryName;

    public ProductDetails() {
    }

    public ProductDetails(String productName, double unitPrice, int stock, String brandName, String categoryName) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.brandName = brandName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", stock=" + stock +
                ", brandName='" + brandName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

package com.example.Assignment.Class;
import java.util.List;


public class Product {
    private int productId;
    private String name;
    private String description;
    private String productImage;
    private float price;
    private int stockQuantity;
    private Order order;

    public Product() {
    }

    public Product(int productId, String name, String description, String productImage, float price, int stockQuantity, Order order) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.productImage = productImage;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.order = order;
    }

    public int viewProduct(){
      return productId;
    }

    public int updateStock(int stockQuantity){
        return stockQuantity;
    }

    public String removeProduct(int id){
        return "deleted";
    }

    public Product addProduct(Product product){
        return product.addProduct(product);
    }

    //Getter and Setters
}

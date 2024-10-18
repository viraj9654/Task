package com.example.Assignment.Class;
import com.example.Assignment.Enum.OrderStatus;


import java.util.List;


public class Order {

    private int orderId;
    private int userId;
    private OrderStatus orderStatus;
    private float totalAmount;
    private List<Product> products;
    private Payment payment;
    private User users;

    public Order(int orderId, int userId, OrderStatus orderStatus, float totalAmount, List<Product> products, Payment payment, User users) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.products = products;
        this.payment = payment;
        this.users = users;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateStatus(String status) {
        this.orderStatus =OrderStatus.COMPLETED;
    }

    public List<Product> viewOrderDetails() {
        return products;
    }

    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCELED;
    }

    public void manageOrder(Product product){
        addProduct(product);

    }
    public String createOrder(Order order){
        return "order placed successfully";
    }
    //Getter and Setters
}

package com.example.Assignment.Class;

import com.example.Assignment.Enum.PaymentStatus;


public class Payment {

    private String paymentId;
    private float amount;
    private PaymentStatus status;
    private Order order;

    public Payment(String paymentId, float amount, PaymentStatus status, Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.order = order;
    }

    public void process() {

        this.status = PaymentStatus.COMPLETED;

    }

    public void refund() {

        this.status = PaymentStatus.REFUNDED;
    }
    //Getter and Setters
}

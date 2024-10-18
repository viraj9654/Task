package com.example.Assignment.Class;


import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private List<Order> orders;

    public User() {
    }
    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = new ArrayList<>();
    }
    public boolean loginUser(String inputUsername, String inputPassword) {
        if (name.equals(inputUsername) && password.equals(inputPassword)) {

           return true;
        } else {
            return false;
        }
    }

    public int logoutUser() {
        return userId;
    }

    public void createUser(String name, String email, String password) {
        System.out.println("User created: " + name);
    }


    public void deleteUser(int userId) {
        System.out.println("User with ID " + userId + " deleted.");
    }
    public void updateUser(String newUsername, String newEmail, String newPassword) {

            this.name = newUsername;
            this.email = newEmail;
            this.password = newPassword;
            System.out.println("User information updated.");

    }
    public List<Order> viewOrder() {
        return orders;


        }
    //Getter and Setters
    }




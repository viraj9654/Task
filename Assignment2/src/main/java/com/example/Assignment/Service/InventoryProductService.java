package com.example.Assignment.Service;

import com.example.Assignment.Entity.InventoryProduct;
import com.example.Assignment.Entity.Order;
import com.example.Assignment.Entity.Restock;
import com.example.Assignment.Reopsitory.InventoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryProductService {

    @Autowired
    InventoryProductRepository productRepository;

    private final int restockThreshold = 10;


    public List<InventoryProduct> addproduct(List<InventoryProduct> inventoryProduct){
        List<InventoryProduct> inventoryProduct1= productRepository.saveAll(inventoryProduct);
        return inventoryProduct1;
    }
    public List<InventoryProduct> getProducts(){
       return productRepository.findAll();

    }

    public List<InventoryProduct> processOrder(List<Order> orders){
        List<String> productNames = orders.stream()
                .map(Order::getName)
                .distinct()
                .collect(Collectors.toList());


       List<InventoryProduct>  products = productRepository.findByNameIn(productNames);


        for (Order order : orders) {

            InventoryProduct product = products.stream()
                    .filter(p -> p.getName().equals(order.getName())) // Assuming InventoryProduct has a getName() method
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Product '" + order.getName() + "' does not exist in inventory."));


            if (order.getQuantity() < 1) {
                throw new IllegalArgumentException("Invalid order quantity for '" + order.getName() + "'. Must be greater than zero.");
            }


            if (product.getQuantity() < order.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for '" + order.getName() + "'. Available: " + product.getQuantity() + ", Requested: " + order.getQuantity());
            }


            product.setQuantity(product.getQuantity() - order.getQuantity());
            productRepository.save(product);


            if (product.getQuantity() < restockThreshold) {
                System.out.println("Alert: '" + product.getName() + "' stock is low. Current level: " + product.getQuantity());
            }
        }


        return products;
    }

    public List<InventoryProduct> restockItems(List<Restock> restocks) {

        List<String> productNames = restocks.stream()
                .map(Restock::getName) // Assuming Restock has a method getProductName()
                .distinct()
                .collect(Collectors.toList());
        List<InventoryProduct> products = productRepository.findByNameIn(productNames);


        for (Restock restock : restocks) {
            InventoryProduct product = products.stream()
                    .filter(p -> p.getName().equals(restock.getName()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Product '" + restock.getName() + "' does not exist in inventory. Cannot restock."));


            if (restock.getQuantity() < 1) {
                throw new IllegalArgumentException("Invalid restock quantity for '" + restock.getName() + "'. Must be greater than zero.");
            }

            product.setQuantity(product.getQuantity() + restock.getQuantity());
            productRepository.save(product);
            System.out.println("Restocked '" + product.getName() + "'. New stock level: " + product.getQuantity());
        }

        return products;
    }
}

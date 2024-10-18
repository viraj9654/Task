package com.example.Assignment.Controller;


import com.example.Assignment.Entity.InventoryProduct;
import com.example.Assignment.Entity.Order;
import com.example.Assignment.Entity.Restock;
import com.example.Assignment.Reopsitory.InventoryProductRepository;
import com.example.Assignment.Service.InventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryProductService productService;

    @Autowired
    InventoryProductRepository inventoryProductRepository;


    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody List<InventoryProduct> inventoryProduct){
        productService.addproduct(inventoryProduct);
        return ResponseEntity.ok("Product added successfully.");
    }

    @GetMapping("/get")
    public List<InventoryProduct> getProducts(){

        return productService.getProducts();

    }
    @PostMapping("/orders")
    public List<InventoryProduct> processOrders(@RequestBody List<Order> orders) {

        return   productService.processOrder(orders);
    }


    @PostMapping("/restock")
    public ResponseEntity<String> restockItems(@RequestBody List<Restock> restocks) {
        productService.restockItems(restocks);
        return ResponseEntity.ok("Items restocked successfully.");
    }
    }


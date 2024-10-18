package com.example.Assignment.Reopsitory;

import com.example.Assignment.Entity.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryProductRepository extends JpaRepository<InventoryProduct,Integer> {

  public  List<InventoryProduct> findByNameIn(List<String> names);
}

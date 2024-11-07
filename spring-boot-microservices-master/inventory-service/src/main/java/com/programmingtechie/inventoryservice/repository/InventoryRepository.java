package com.programmingtechie.inventoryservice.repository;

import com.programmingtechie.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> { // Long: for Long id
    List<Inventory> findBySkuCodeIn(List<String> skuCode); // JPA automatically will implement this method to find by Sku code, at the Runtime
    													   // it generate the query
    
    //Optional<Invetory> findBySkuCode(String skuCode);
}

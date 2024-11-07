package com.programmingtechie.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    
    // Start loading data in database
    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
    	return args -> {
    		Inventory inventory = new Inventory();
    		inventory.setSkuCode("iphone_13");
    		inventory.setQuantity(100);
    		
    		Inventory inventory1 = new Inventory();
    		inventory1.setSkuCode("iphone_13_red");
    		inventory1.setQuantity(0);
    		
    		inventoryRepository.save(inventory);
    		inventoryRepository.save(inventory1);
    	};
    }
}

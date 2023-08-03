package com.sahil.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sahil.inventoryservice.repository.InventoryRepository;
import com.sahil.inventoryservice.model.Inventory;
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone 11");
			inventory.setQuantity(5);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone 12");
			inventory1.setQuantity(0);
			
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("iphone 13");
			inventory2.setQuantity(15);
			
			Inventory inventory3 = new Inventory();
			inventory3.setSkuCode("iphone 14");
			inventory3.setQuantity(10);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);
		};
	}
}

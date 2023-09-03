package com.example.inventoryservice;

import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone10");
			inventory.setQuantity(100);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Iphone11");
			inventory2.setQuantity(1);

			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory);
		};
	}

}

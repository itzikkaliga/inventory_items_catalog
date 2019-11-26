package com.in28minutes.springboot.studentservices;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.studentservices.inventoryitems.InventoryItemsRepository;
import com.in28minutes.springboot.studentservices.inventoryitems.InvItem;


@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(JpaRepository<InvItem,Long> repository) {
        return args -> {
        };
    }

}

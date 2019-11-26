package com.in28minutes.springboot.studentservices.inventoryitems;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemsRepository extends JpaRepository<InvItem,Long>{

}

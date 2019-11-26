package com.in28minutes.springboot.studentservices.inventoryitems;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemRepoImpl implements ItemsRepo{
	
	@Autowired
	private InventoryItemsRepository repository;
	
	 
	 public List<InvItem> retrieveEmployees() {
		  List<InvItem> itemsList = repository.findAll();
		  return itemsList;
	}
		  
		 public InvItem getItem(Long itemId) {
			 Optional<InvItem> item = repository.findById(itemId);
			 if(item.isPresent())
				 return item.get();
			 return null;
		 }
		  
		 public void saveItem(InvItem item){
			 repository.save(item);
		 }
		  
		 public void deleteItem(Long itemId){
			 repository.deleteById(itemId);
		 }


}

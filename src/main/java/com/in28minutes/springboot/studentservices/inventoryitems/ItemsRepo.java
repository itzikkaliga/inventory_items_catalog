package com.in28minutes.springboot.studentservices.inventoryitems;

import java.util.List;

public interface ItemsRepo {
	
	public List<InvItem> retrieveEmployees();
	public InvItem getItem(Long itemId);
	public void saveItem(InvItem item);
	public void deleteItem(Long itemId);
}


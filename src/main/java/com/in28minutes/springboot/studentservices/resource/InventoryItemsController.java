package com.in28minutes.springboot.studentservices.resource;


import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.studentservices.inventoryitems.InvItem;
import com.in28minutes.springboot.studentservices.inventoryitems.ItemRepoImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/rest/Inventory")
@Api(value = "Maintaining an Inventory Items Repository")
public class InventoryItemsController {
	
	@Autowired
	private ItemRepoImpl itemRepo;
	
	
	 public void setInventoryItemsRepository(ItemRepoImpl itemRepo) {
		  this.itemRepo = itemRepo;
	}
	
	@GetMapping
	@ApiOperation(value = "Returns a List of all the items")
	public List<InvItem> getAllItems(){
		return itemRepo.retrieveEmployees();
	}
	
	@GetMapping("/{itemNum}")
	@ApiOperation(value = "Returns a specific item if exsits", 
	notes="if the item number is valid\n"
			+ "then it will return an item\n"
			+ "if not it wiil return null")
	public InvItem getItemByItemNum(
			@RequestParam(value = "Item number", required = true) long itemNum){
			return itemRepo.getItem(itemNum);
	}
	
	@PutMapping("/withdraw")
	@ApiOperation(value = "Decrease amount from a specific item",
	notes = "if there is not an item with\n"
			+ "the requsted number then\n"
			+ "nothing will happen.\n"
			+ "please give a positive number.")
	public String withdrawQuant(
			@RequestParam(value = "Item number", required = true) long itemNum, 
			@RequestParam(value = "Amount", required = true) int decAmount){
		if(decAmount<0)
			return "Only positive numbers";
		InvItem item = itemRepo.getItem(itemNum);
		if(item!=null) {
			if(item.getAmount()<decAmount)
				return "the wanted amount is to big";
			item.decAmount(decAmount);
			itemRepo.saveItem(item);
			return "Successful withdraw quant";
		}
		else
			return "There is not such item number";
	}
	
	@PutMapping("/deposit")
	@ApiOperation(value = "Add amount from a specific item",
			notes = "if there is not an item with\n"
					+ "the requsted number then\n"
					+ "nothing will happen.\n"
					+ "please give a positive number.")
	public String depositItem(
			@RequestParam(value = "Item number", required = true) long itemNum, 
			@RequestParam(value = "Amount", required = true)int addAmount){
		if(addAmount<0)
			return "Only positive numbers";
		InvItem item = itemRepo.getItem(itemNum);
		if(item!=null) {
			item.addAmount(addAmount);
			itemRepo.saveItem(item);
			return "Successful deposit";
		}
		else
			return "There is not such item number";

	}
	
	@PutMapping("/addItem")
	@ApiOperation(value = "Add an item to repository",
			notes = "if there is not an item with\n"
					+ "the requsted number then\n"
					+ "nothing will happen.")
	public String addItem(
	@RequestParam(value = "Item number", required = true) long itemno, 
	@RequestParam(value = "Item Name", required = true) String name, 
	@RequestParam(value = "Amount", required = true) int amount, 
	@RequestParam(value = "Code", required = true)String invCode){
		if(itemno<1)
			return "need valid id";
		if(name.isEmpty())
			return "need valid name";
		if(invCode.isEmpty())
			return "need valid code";
		if(amount<0)
			return "need positive amount";
		itemRepo.saveItem(new InvItem(itemno, name, amount, invCode));
		return "item added successfuly";
	}

	@PutMapping("/deleteItem")
	@ApiOperation(value = "Delete an item from repository",
			notes = "if there is not an item with\n"
					+ "the requsted number then\n"
					+ "nothing will happen.")
	public String deleteItem(
			@RequestParam(value = "Item number", required = true) long itemno){
		itemRepo.deleteItem(itemno);
		return "The item has been deleted";
	}
}

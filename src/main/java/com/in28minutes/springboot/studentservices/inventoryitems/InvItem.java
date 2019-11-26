package com.in28minutes.springboot.studentservices.inventoryitems;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class InvItem {
	
	@Id
	@ApiModelProperty(notes = "The ID of the item")
	private long itemno;
	
	@ApiModelProperty(notes = "The name of the item")
	private String name;
	
	@ApiModelProperty(notes = "The amount of the item")
	private int amount;
	
	@ApiModelProperty(notes = "The code of the item")
	private String invCode;
	
	public InvItem() {
		
	}
	
	public InvItem(long itemno, String name, int amount, String invCode) {
		this.itemno = itemno;
		this.name = name;
		this.amount = amount;
		this.invCode = invCode;
	}
	
	public long getItemno() {
		return itemno;
	}
	
	public void setItemno(long itemno) {
		 this.itemno = itemno;
	}
	
	//public long getId() {
		//return Id;
	//}
	
	
	public String getName() {
		return name;
	}
	public String getInvcode() {
		return invCode;
	}
	public int getAmount() {
		return amount;
	}
	
	public void addAmount(int newAmount) {
		amount = amount + newAmount;
	}
	
	public void decAmount(int newAmount) {
		amount = amount - newAmount;
	}
	


}

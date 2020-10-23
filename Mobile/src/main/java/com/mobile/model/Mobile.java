package com.mobile.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mobiles")
public class Mobile {
	@Id
	private int mobileId;
	private String mobileName;
	private double price;
	
	private Date date;
	
	
	
	public Mobile() {
		super();
	}
	public Mobile(int mobileId, String mobileName, double price, Date date) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.price = price;
		
		this.date = date;
	}
	public int getStockId() {
		return mobileId;
	}
	public void setStockId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getStockName() {
		return mobileName;
	}
	public void setStockName(String mobileName) {
		this.mobileName = mobileName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

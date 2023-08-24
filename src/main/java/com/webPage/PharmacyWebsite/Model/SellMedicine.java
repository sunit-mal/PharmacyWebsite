package com.webPage.PharmacyWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class SellMedicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String uuid;
	@Column
	private String medicineName;
	@Column
	private String expiryDate;
	@Column
	private String quantity;
	@Column
	private String price;
	public SellMedicine(int id, String uuid, String medicineName, String expiryDate, String quantity, String price) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.medicineName = medicineName;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
		this.price = price;
	}
	public SellMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public boolean FindByUUID(String uuid) {
		return getUuid().equals(uuid);
	}
}

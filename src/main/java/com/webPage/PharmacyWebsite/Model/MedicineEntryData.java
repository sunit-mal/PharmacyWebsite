package com.webPage.PharmacyWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MedicineEntryData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String MedicineName;
	@Column
	private String entryDate;
	@Column
	private String expiryDate;
	@Column
	private long quantity;
	@Column
	private float price;

	public MedicineEntryData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicineEntryData(int id, String medicineName, String entryDate, String expiryDate, long quantity, float price) {
		super();
		this.id = id;
		MedicineName = medicineName;
		this.entryDate = entryDate;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	searching by using medicine name
	public boolean searchByName(String name) {
		name.toLowerCase();
		String medString = MedicineName.toLowerCase();
		return medString.contains(name);
	}

//	Searching by using Expiry date
	public boolean searchByExpirydate(String expDate) {
		return expiryDate.equals(expDate);
	}

// searching by quantity of medicine
	public boolean searchByQuantity(long amount) {
		return (quantity == amount);
	}
}

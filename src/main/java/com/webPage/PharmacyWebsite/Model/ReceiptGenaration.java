package com.webPage.PharmacyWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ReceiptGenaration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int medecineid;
	@Column
	private long quantity;
	public ReceiptGenaration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReceiptGenaration(int id, int medecineid, long quantity) {
		super();
		this.id = id;
		this.medecineid = medecineid;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMedecineid() {
		return medecineid;
	}
	public void setMedecineid(int medecineid) {
		this.medecineid = medecineid;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	} 
}

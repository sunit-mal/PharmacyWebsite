package com.webPage.PharmacyWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class InvoiceData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String CustomerName;
	@Column
	private String ContectNumber;
	@Column
	private String visitDate;
	@Column
	private String uuid;
	@Column
	private float Totalprice;
	
	public InvoiceData(int id, String customerName, String contectNumber, String visitDate, String uuid,float Totalprice) {
		super();
		this.id = id;
		CustomerName = customerName;
		ContectNumber = contectNumber;
		this.visitDate = visitDate;
		this.uuid = uuid;
		this.Totalprice = Totalprice;
	}

	public InvoiceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getContectNumber() {
		return ContectNumber;
	}

	public void setContectNumber(String contectNumber) {
		ContectNumber = contectNumber;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public float getTotalprice() {
		return Totalprice;
	}

	public void setTotalprice(float Totalprice) {
		this.Totalprice = Totalprice;
	}
	public String genUUID() {
		return UUIDGENARATION.uuidGenaration();
	}
	
	public boolean uuidMatch(String uuid) {
		return getUuid().equals(uuid);
	}

	//	Searching Process
	public boolean nameMatch(String name) {
		String SearchName = name.toLowerCase();
		String Orginal = getCustomerName().toLowerCase();
		return Orginal.contains(SearchName);
	}
	public boolean dateCheck(String date) {
		date.toLowerCase();
		String Orginal = getVisitDate().toLowerCase();
		return Orginal.contains(date);
	}
}

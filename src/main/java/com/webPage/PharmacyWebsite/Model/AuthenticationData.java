package com.webPage.PharmacyWebsite.Model;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AuthenticationData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String userName;
	@Column
	private String password;
	
	public AuthenticationData(int id, String name, String email, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public AuthenticationData() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		byte[] encodedBytes = Base64.getEncoder().encode(userName.getBytes());
		this.userName = new String(encodedBytes);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
		this.password = new String(encodedBytes);
	}
	
	// Login Credentials Check
	public boolean validation(String uname, String Password) {
		byte[] decodedBytesForUname = Base64.getDecoder().decode(getUserName());
		String decodedUname = new String(decodedBytesForUname);

		byte[] decodedBytesForPass = Base64.getDecoder().decode(getPassword());
        String decodedpass = new String(decodedBytesForPass);
        
		return decodedUname.equals(uname) && decodedpass.equals(Password);
	}
	
	public boolean unameValidation(String uname) {
		byte[] decodedBytesForUname = Base64.getDecoder().decode(getUserName());
		String decodedUname = new String(decodedBytesForUname);
		
		return decodedUname.equals(uname);
	}
}

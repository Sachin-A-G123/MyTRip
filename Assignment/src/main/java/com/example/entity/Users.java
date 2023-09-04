package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private  String uid;
	private  String name;
	private  String email;
	private  String mobileNumber;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Users(String uid, String name, String email, String mobileNumber) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public Users() {
		super();
	}
	

}

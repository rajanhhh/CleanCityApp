package com.clean.springbootstarter.beans;

import java.io.InputStream;

public class UserInfo {
	
	private String name;
	private String address;
	private String pin;
	
	private String phone_number;
	
	private InputStream photo;
	
	public UserInfo() {
		
	}
	
	public  UserInfo(String name, String address,String pin,String phone_number, InputStream photo) {
		
		this.name=name;
		this.address=address;
		this.pin=pin;
		this.phone_number=phone_number;
		this.photo=photo;
		
	}

public  UserInfo(String name, String address,String pin,String phone_number) {
		
		this.name=name;
		this.address=address;
		this.pin=pin;
		this.phone_number=phone_number;
		
		
	}
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	
	

}

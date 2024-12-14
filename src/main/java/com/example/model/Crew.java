package com.example.model;

public class Crew {
	String name;
	String email;
	String phoneNo;
	String position;
	int year;
	
	public Crew() {
		
	}
	
	public Crew(String name, String email, String phoneNo, String position, int year) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.position = position;
		this.year = year;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}

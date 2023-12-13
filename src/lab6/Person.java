package lab6;

public class Person {
	private String givenName;
	private String surName;
	private int phoneNumber;
	
	public Person(String firstName, String lastName, int phone) {
		this.givenName = firstName;
		this.surName = lastName;
		this.phoneNumber = phone;
	}
	
	
	public String getSurName() {
		return this.surName;
	}
	
	public String getFullName() {
		return this.givenName+" "+this.surName;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
}

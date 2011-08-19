package com.sourceallies.interview;

public class Person {
	
	private long id;
	private String firstName;
	
	public Person(String firstName) {
		this.firstName = firstName;
	}
	
	public Person() { 
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}

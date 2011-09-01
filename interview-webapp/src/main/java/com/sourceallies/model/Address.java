package com.sourceallies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	@SuppressWarnings("unused")
	@Id
    @GeneratedValue
    @Column(name = "Id")
    private long id = -1;

	@Column(name = "Street", length = 100)
	private String street;
	
	@Column(name = "City", length = 50)
	private String city;
	
	@Column(name = "State", length = 2)
	private State state;
	
	@Column(name = "Zip", length = 5)
	private String zip;

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public State getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
}

package com.sourceallies.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



@Entity
@Table(name = "Person")
@Component("person")
public class Person {
		
	@Id
    @GeneratedValue
    @Column(name = "Id")
    private long id = -1;
	
	@Column(name = "FirstName", length = 50)
	@NotEmpty
    private String firstName;
	
	@Column(name = "LastName", length = 50)
    private String lastName;

	@JoinTable(
		name="Person_Address",
		joinColumns=@JoinColumn(name="Person_Id"),
		inverseJoinColumns=@JoinColumn(name="Address_Id")
	)
	@ManyToMany(cascade={CascadeType.ALL})
	private List<Address> addresses;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Address> getAddresses() {
		return addresses;
	}
}

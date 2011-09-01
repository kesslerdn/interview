package com.sourceallies.dao;

import java.util.List;

import com.sourceallies.model.Person;

public interface PersonDao {

	public void save(Person person);

	public List<Person> findAll();

	public List<Person> findByLastName(String lastName);
}
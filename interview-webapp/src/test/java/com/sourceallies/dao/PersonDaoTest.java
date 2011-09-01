package com.sourceallies.dao;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sourceallies.model.Address;
import com.sourceallies.model.Person;
import com.sourceallies.model.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/context.xml"})
@TransactionConfiguration
@Transactional
public class PersonDaoTest{

    
    @Resource  
    private PersonDao personDao;
    
    @Resource
    private SessionFactory sessionFactory;

    @Test
    public void testSave(){
        Person firstPerson = createPerson("One", "First");
        
        Person secondPerson = createPerson("Two", "Second");
        
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(createAddress("1 street", "firstCity", State.IA, "11111"));
        addresses.add(createAddress("2 street", "secondCity", State.SD, "22222"));
		firstPerson.setAddresses(addresses);
        secondPerson.setAddresses(addresses);

        personDao.save(firstPerson);
        personDao.save(secondPerson);
        
        sessionFactory.getCurrentSession().flush();

        List<Person> people = personDao.findAll();

        assertEquals(2, people.size());

        Person firstActual = people.get(0);
        Person secondActual = people.get(1);

        assertEquals(firstPerson.getFirstName(), firstActual.getFirstName());
        assertEquals(firstPerson.getLastName(), firstActual.getLastName());
        assertEquals(firstPerson.getAddresses().size(), firstActual.getAddresses().size());
        assertAddress(firstPerson.getAddresses().get(0), firstActual.getAddresses().get(0));
		assertAddress(firstPerson.getAddresses().get(1), firstActual.getAddresses().get(1));

        assertEquals(secondPerson.getFirstName(), secondActual.getFirstName());
        assertEquals(secondPerson.getLastName(), secondActual.getLastName());
        assertEquals(secondPerson.getAddresses().size(), secondActual.getAddresses().size());
        assertAddress(secondPerson.getAddresses().get(0), secondActual.getAddresses().get(0));
        assertAddress(secondPerson.getAddresses().get(1), secondActual.getAddresses().get(1));
      
    }

	private Person createPerson(String firstName, String lastName) {
		Person firstPerson = new Person();
        firstPerson.setFirstName(firstName);
        firstPerson.setLastName(lastName);
		return firstPerson;
	}
    
    @Test
    public void testFindByLastName(){
    	Person firstPerson = createPerson("One", "First");
    	Person secondPerson = createPerson("Two", "Bobberson");
        Person thirdPerson = createPerson("Three", "Third");
        
        personDao.save(firstPerson);
        personDao.save(secondPerson);
        personDao.save(thirdPerson);
        
        sessionFactory.getCurrentSession().flush();
        
    	List<Person> people = personDao.findByLastName("Bobberson");
    	
    	assertEquals(1, people.size());
    	assertEquals(secondPerson.getFirstName(), people.get(0).getFirstName());
    	assertEquals(secondPerson.getLastName(), people.get(0).getLastName());
    }

	private void assertAddress(Address expectedAddress, Address actualAddress) {
		assertEquals(expectedAddress.getStreet(), actualAddress.getStreet());
		assertEquals(expectedAddress.getCity(), actualAddress.getCity());
		assertEquals(expectedAddress.getState(), actualAddress.getState());
		assertEquals(expectedAddress.getZip(), actualAddress.getZip());
	}

	private Address createAddress(String street, String city, State state, String zip ) {
		Address firstAddress = new Address();
        firstAddress.setStreet(street);
        firstAddress.setCity(city);
        firstAddress.setState(state);
        firstAddress.setZip(zip);
		return firstAddress;
	}


}

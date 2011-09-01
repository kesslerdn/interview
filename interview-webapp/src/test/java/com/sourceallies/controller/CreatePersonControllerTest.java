package com.sourceallies.controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.ModelMap;

import static org.mockito.Mockito.*;

import com.sourceallies.dao.PersonDao;
import com.sourceallies.model.Person;


public class CreatePersonControllerTest {
	
	CreatePersonController controller;
	Person mockPerson;
	PersonDao mockPersonDao;
	
	@Before
	public void setUp(){
		controller = new CreatePersonController();
		
		mockPerson = mock(Person.class);
		mockPersonDao = mock(PersonDao.class);
		
		controller.setPerson(mockPerson);
		controller.setPersonDao(mockPersonDao);
	}

	@Test
	public void testSetupPerson(){
		ModelMap modelMap = controller.setupForm();
		
		assertNotNull(modelMap);
		assertSame(mockPerson, modelMap.get("person"));
	}
	
	@Test
	public void testCreate(){
		controller.create(mockPerson, null);
		
		verify(mockPersonDao).save(mockPerson);
	}
}

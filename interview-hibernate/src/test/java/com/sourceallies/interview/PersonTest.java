package com.sourceallies.interview;

import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PersonTest {
	
	private SessionFactory sessionFactory;

	@Before
	public void setUp(){
		//setup SessionFactory
	}

	@After
	public void tearDown(){
		
	}

	@Test
	public void testSaveAndFind() {
		//save two Person instances
		
		//find all saved People
		//assert there are 2 results
		assertTrue(true);
	}

}

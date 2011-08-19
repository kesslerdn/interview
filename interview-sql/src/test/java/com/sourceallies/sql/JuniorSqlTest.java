package com.sourceallies.sql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class JuniorSqlTest extends AbstractSqlTestCase{

	@Test
	public void testSelectAllColumns(){
		assertQueryResults("select * from Person;", 
								"PERSON\n" +
								"=================================\n" +
								"ID, FIRSTNAME, LASTNAME\n" +
								"1, andy, anderson\n" +
								"2, bob, bobberson\n" +
								"3, fred, fredrickson\n" +
								"4, carry, carlson\n" +
								"5, david, davidson\n" +
								"6, erin, ericson\n" +
								"7, greg, grossman\n" +
								"8, harry, hanover\n"
								);
	}
	
	@Test
	public void testSelectLastName(){
		assertQueryResults("select LASTNAME from Person;", 
								"PERSON\n" +
								"=================================\n" +
								"LASTNAME\n" +
								"anderson\n" +
								"bobberson\n" +
								"fredrickson\n" +
								"carlson\n" +
								"davidson\n" +
								"ericson\n" +
								"grossman\n" +
								"hanover\n"
								);
	}
	
	@Test
	public void testSelectCount(){
		int count = jdbcTemplate.queryForInt("select count(*) from Person;");
		assertEquals(8, count);
	}
	
	@Test
	public void testOrderBy(){
		assertQueryResults("select * from Person order by LastName;", 
				"PERSON\n" +
				"=================================\n" +
				"ID, FIRSTNAME, LASTNAME\n" +
				"1, andy, anderson\n" +
				"2, bob, bobberson\n" +
				"4, carry, carlson\n" +
				"5, david, davidson\n" +
				"6, erin, ericson\n" +
				"3, fred, fredrickson\n" +
				"7, greg, grossman\n" +
				"8, harry, hanover\n"
				);
	}
	
	@Test
	public void testWhereClause(){
		assertQueryResults("select * from Person where LastName = 'bobberson';", 
				"PERSON\n" +
				"=================================\n" +
				"ID, FIRSTNAME, LASTNAME\n" +
				"2, bob, bobberson\n"
				);
	}
}

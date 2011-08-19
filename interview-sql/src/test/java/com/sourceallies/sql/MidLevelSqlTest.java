package com.sourceallies.sql;

import org.junit.Test;


public class MidLevelSqlTest extends AbstractSqlTestCase{

	@Test
	public void testWhereClause(){
		assertQueryResults("select * from Person where LastName like '%son';", 
				"PERSON\n" +
				"=================================\n" +
				"ID, FIRSTNAME, LASTNAME\n" +
				"1, andy, anderson\n" +
				"2, bob, bobberson\n" +
				"3, fred, fredrickson\n" +
				"4, carry, carlson\n" +
				"5, david, davidson\n" +
				"6, erin, ericson\n"
				);
	}
}

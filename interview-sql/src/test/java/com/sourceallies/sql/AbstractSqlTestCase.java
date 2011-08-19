package com.sourceallies.sql;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/database-context.xml"})
public abstract class AbstractSqlTestCase {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected void assertQueryResults(String query, String expectedResults){
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		SqlRowSetMetaData metaData = results.getMetaData();
		String actualResults = metaData.getTableName(1) + "\n";
		actualResults += "=================================\n";
		boolean firstTime = true;
		for(String columnName : metaData.getColumnNames()){
			if(!firstTime) actualResults += ", ";
			firstTime = false;
			actualResults += columnName;
		}
		actualResults += "\n";
		while(results.next()){
			firstTime = true;
			for(int i = 1; i <= metaData.getColumnCount(); i++){
				if(!firstTime) actualResults += ", ";
				firstTime = false;
				actualResults += results.getObject(i).toString();
			}
			actualResults += "\n";
		}
		assertEquals(expectedResults, actualResults);
	}
}

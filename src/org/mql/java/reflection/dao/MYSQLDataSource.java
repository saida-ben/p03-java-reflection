package org.mql.java.reflection.dao;

import java.sql.Connection;

public class MYSQLDataSource implements DataSource{
	

	public MYSQLDataSource() {
		System.out.println("new MYSQLDataSource ");
	}
	
	public Connection getConnection(){
		System.out.println("");
		
		return null;
	}

}

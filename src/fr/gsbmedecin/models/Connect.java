package fr.gsbmedecin.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private Connection con = null;
	
	private final String ADRESS = "localhost";
	private final String PORT = "5432";
	private final String DATABASE = "gsbmedecins";
	private final String USER = "gsbmedecins";
	private final String PASSWORD = "gsbmedecins";
	
	
	private void open() {
		try {
			Class.forName("org.postgresql.Driver");
	        con = DriverManager
	            .getConnection("jdbc:postgresql://"+ADRESS+":"+PORT+"/"+DATABASE,
	            USER, PASSWORD);
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
	    }
	    System.out.println("Opened database successfully");
   }
	
	public Connection get() {
		try {
			if(con == null || con.isClosed()) {
				open();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
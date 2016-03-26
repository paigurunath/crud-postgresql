package com.predix.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnectionManager {

	Properties props = new Properties();
	Connection con = null;

	String CLASS_NAME = this.getClass().getName();
	Logger logger = Logger.getLogger(CLASS_NAME);

	public Connection getConnection() {
		
		logger.info("Entering " + CLASS_NAME);

		try {

	//	File Path =new File("resources/mars.properties");
		
	
			//FileInputStream fis = new FileInputStream(Path.getAbsolutePath());

//System.out.println(Path.getAbsolutePath());

			
			//FileInputStream fis = new FileInputStream("D:/mars/resources/mars.properties");

		

	       // props.load(fis);
			
			/*Class.forName(props.getProperty("jdbc.driver"));
			con = DriverManager.getConnection(props.getProperty("jdbc.connectionurl"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			*/
	        //	jdbc:mysql://localhost:3306/dbname
	        Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			
			
			if (con != null) {
				logger.info("Connection created Successfully !");
				System.out.println("Connection created Successfully !");
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return con;
	}
	
	/*public static void main(String args[]) {
		DBConnectionManager dbc = new DBConnectionManager();
		dbc.getConnection();
	}*/
}
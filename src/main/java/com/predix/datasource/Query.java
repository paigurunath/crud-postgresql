package com.predix.datasource;

public class Query {

	public static String CREATE_COMPANY = "CREATE TABLE  IF NOT EXISTS  COMPANY  (ID SERIAL PRIMARY KEY , NAME  TEXT NOT NULL,AGE TEXT NOT NULL,  ADDRESS TEXT NOT NULL,SALARY TEXT NOT NULL)";
	public static String INSERT_COMPANY = "INSERT INTO COMPANY (NAME,AGE,ADDRESS,SALARY) VALUES (  ?, ?, ?, ?)";
	public static String VIEW_ALL_COMPANY = "SELECT ID, NAME, AGE, ADDRESS, SALARY FROM COMPANY";
	
}
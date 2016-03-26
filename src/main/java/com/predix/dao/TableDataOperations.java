package com.predix.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.predix.datasource.Query;
import com.predix.datasource.QueryInteractor;
import com.predix.model.Company;

public class TableDataOperations {

	QueryInteractor qi = null;
	
 	public String createTable() {
		
		try {
			qi = new QueryInteractor();
			qi.executeUpdateQuery(Query.CREATE_COMPANY);
			
			return "Table created successfully";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 	
 	public String insertDataTable(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_COMPANY, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public List<Company> viewData() {
 		
 		List<Company> companyList = new ArrayList<Company>();
 		Company company = null;
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getList(Query.VIEW_ALL_COMPANY);
 			
 			int k = 0;
 			for(int i=1; i<listObject.size(); i++) {
 				
 				Object[] obj = (Object[])listObject.get(i);
 				company = new Company();
 				company.setId(Integer.parseInt(obj[k++].toString()));
 				company.setName(obj[k++].toString());
 				company.setAge(obj[k++].toString());
 				company.setAddress(obj[k++].toString());
 				company.setSalary(obj[k++].toString());
 				
 				companyList.add(company);
 				k = 0;
 			}
 			return companyList; 
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
	/*public static void main(String args[]) {
		
		TableDataOperations tdo = new TableDataOperations();
		
		//tdo.createTable();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(new Integer(1), "gurunath");
		hm.put(new Integer(2), "25");
		hm.put(new Integer(3), "flat no 2, road no 3");
		hm.put(new Integer(4), "25.00");
		//hm.put(new Integer(5), "1");
		
		
		tdo.insertDataTable(hm);
		tdo.viewData();
		
	}*/
}

package com.example;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.predix.dao.TableDataOperations;
import com.predix.model.Company;

@RestController
public class GreetingController {

	@RequestMapping("/")
	String home() {
		return "Hello I am from Postgresql!!!!";
	}
	
    @RequestMapping(value="/createTable", method=RequestMethod.POST)
	public String createTable() {
		try {
			TableDataOperations tdo = new TableDataOperations();
			return tdo.createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/insertTableData", method=RequestMethod.POST)
	public String insertTableData(@RequestBody Company company ) {
		try {
			TableDataOperations tdo = new TableDataOperations();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getName());
			hm.put(new Integer(2), company.getAge());
			hm.put(new Integer(3), company.getAddress());
			hm.put(new Integer(4), company.getSalary());
			
			return tdo.insertDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/retrieveTableData", method=RequestMethod.POST)
	public @ResponseBody List<Company> retrieveTableData() {
		try {
			TableDataOperations tdo = new TableDataOperations();
			return tdo.viewData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
   
}
package com.predix.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.predix.dao.TableDataOperations;
import com.predix.model.Company;

@RestController
@EnableAutoConfiguration
public class CreateReadUpdateDelete {

	TableDataOperations tdo = new TableDataOperations();
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value="/createTable", method=RequestMethod.POST)
	public String createTable() {
		try {
			return tdo.createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/insertTableData", method=RequestMethod.POST)
	public String insertTableData(@RequestBody Company company ) {
		try {
			
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
	
	@RequestMapping(value="/retrieveTableData", method=RequestMethod.GET)
	public @ResponseBody List<Company> retrieveTableData() {
		try {
			return tdo.viewData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

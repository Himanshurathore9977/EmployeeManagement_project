package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.Entity.EmployeeDAO;


public class CheckAdmin {
	public static boolean  checkAdmin(List<EmployeeDAO> employeelist, String name) {
		   return  ! employeelist.stream()
									.filter(a -> a.getName().equalsIgnoreCase(name) && a.getDesignation().equalsIgnoreCase("admin"))
									.map(c -> c.getName())
									.collect(Collectors.toList())
									.isEmpty(); 
									 
			
	}
	
	public static List<EmployeeDAO> getEmployeeDetails(List<EmployeeDAO> employeelist, String name){
		List<EmployeeDAO> employeeList =employeelist.stream().filter(a -> a.getName().equalsIgnoreCase(name)).collect(Collectors.toList()) ; 
		//employeelist.stream().forEach(a -> System.out.println(a.getName()));
		return employeeList; 
	}
}

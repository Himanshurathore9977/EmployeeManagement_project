package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.Entity.EmployeeDAO;

public class CheckLoginCredentials {
	public boolean checkLogin(List<EmployeeDAO> employeelist , String name , String passWord) {
		 return ! employeelist.stream().filter(a -> a.getName().equalsIgnoreCase(name) && a.getPassword().equalsIgnoreCase(passWord))
				.map(a -> a.getName())
				.collect(Collectors.toList())
				.isEmpty() 
				; 
	}
}

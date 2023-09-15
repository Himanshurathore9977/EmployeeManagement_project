package com.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.Entity.EmployeeDAO;

public class EmployeeSort {
	public List<EmployeeDAO> sortList(List<EmployeeDAO> employeeList ){
		return  employeeList.stream().sorted(Comparator.comparingInt(EmployeeDAO::getUserID)).collect(Collectors.toList()) ; 
	}
}

package com.service;

import java.util.ArrayList;
import java.util.List;

import com.Entity.EmployeeDAO;

public class SetCrediantials {
	List<EmployeeDAO>  employeeList = new ArrayList<EmployeeDAO>() ; 
	public List<EmployeeDAO> setDetails(List<EmployeeDAO> pdetails){
		EmployeeDAO e1 = new EmployeeDAO() ; 
		e1.setName("jay");
		e1.setUserID(1);
		e1.setPassword("jay");
		e1.setPhone_no(999);
		e1.setDesignation("Software Develeper ") ;
		employeeList.add(e1) ; 
		//
		employeeList.add(new EmployeeDAO("nil", "nil", 2,  888, "Senior Android Develpoer ")) ; 
		employeeList.add(new EmployeeDAO("hri" , "hri", 3, 777, "Senior Full Stack Developer")) ; 
		employeeList.add(new EmployeeDAO("jayesh", "jayesh", 4,888, "admin")) ; 
		employeeList.add(new EmployeeDAO("hritik" , "hritik", 5, 777, "React Developer")) ; 
		employeeList.add(new EmployeeDAO("param", "param", 6, 888, "Senior Android Develpoer ")) ; 
		employeeList.add(new EmployeeDAO("nilesh", "nilesh", 7, 888, "Senior Android Develpoer ")) ; 
		employeeList.add(new EmployeeDAO("rimzim" , "rimzim", 8, 777, "admin")) ; 
		employeeList.add(new EmployeeDAO("disha", "disha", 9, 888, "Senior Android Develpoer ")) ; 
		employeeList.add(new EmployeeDAO("himanshu" , "himanshu", 10, 777, "admin")) ; 
		
		return employeeList ; 
	}
}

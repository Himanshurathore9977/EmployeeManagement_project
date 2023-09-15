package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.EmployeeDAO;
import com.service.EmployeeSort;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/addEmp")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid")) ; 
		String username = request.getParameter("username") ; 
		String password  = request.getParameter("password") ; 
		int phoneno = Integer.parseInt(request.getParameter("phone")) ; 
		String designation = request.getParameter("designation") ; 
		
		HttpSession hs=request.getSession();
		List <EmployeeDAO> employeeList = (List<EmployeeDAO>)hs.getAttribute("employeeList") ; 
		EmployeeDAO newemployeeData = new EmployeeDAO(username , password , userid , phoneno, designation) ; 
		employeeList.add(newemployeeData); 
		
		employeeList = new EmployeeSort().sortList(employeeList) ; 
		
		hs.setAttribute("employeeList", employeeList) ;
		
		response.sendRedirect("adminPage.jsp") ; 
	}

}

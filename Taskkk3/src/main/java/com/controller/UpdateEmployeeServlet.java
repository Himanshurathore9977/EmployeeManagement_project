package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.EmployeeDAO;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmp")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		HttpSession session = request.getSession() ; 
		EmployeeDAO employeeData  = (EmployeeDAO) session.getAttribute("employeeData") ; 
		List<EmployeeDAO> employeeList  = (List<EmployeeDAO>) session.getAttribute("employeeList") ; 
		employeeList.remove(employeeData) ;
		session.setAttribute("employeeList", employeeList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployeePage.jsp");
		dispatcher.forward(request , response); 
	}

}

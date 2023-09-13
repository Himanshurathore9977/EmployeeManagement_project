package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.EmployeeDAO;

/**
 * Servlet implementation class deleteServlets
 */
@WebServlet("/deleteServlets")
public class deleteServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
				int userID = Integer.parseInt(request.getParameter("username")) ; 
				System.out.println("hey " + userID);
				HttpSession session = request.getSession() ; 
				
				List<EmployeeDAO> employeeList  = (List<EmployeeDAO>) session.getAttribute("employeeList") ;
				 
				employeeList = employeeList.stream().filter(a -> a.getUserID() != (userID) ).collect(Collectors.toList()) ;
				session.setAttribute("employeeList", employeeList) ; 
				PrintWriter pw = response.getWriter();
				pw.write("hey sahi hai ") ; 
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
				dispatcher.forward(request , response); 
				
	}

}

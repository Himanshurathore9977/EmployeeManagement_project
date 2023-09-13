package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class UpdatedServlet2
 */
@WebServlet("/update2")
public class UpdatedServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatedServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String designation = request.getParameter("isAdmin") ; 
		
		HttpSession hs=request.getSession();
		List <EmployeeDAO> employeeList = (List<EmployeeDAO>)hs.getAttribute("employeeList") ; 
		
		employeeList.add( new EmployeeDAO(username , password , userid , phoneno, designation) ); 
		hs.setAttribute("employeeList", employeeList) ;
		
		
		PrintWriter pw = response.getWriter() ; 
		pw.write("hello buddy " ); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
		dispatcher.forward(request , response); 
		
	}

}

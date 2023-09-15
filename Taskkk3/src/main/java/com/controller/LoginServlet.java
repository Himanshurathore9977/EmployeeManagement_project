package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.EmployeeDAO;
import com.service.CheckAdmin;
import com.service.CheckLoginCredentials;
import com.service.SetCrediantials;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	List<EmployeeDAO> employeelist = new ArrayList<EmployeeDAO>() ; 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		employeelist =   new SetCrediantials().setDetails(employeelist) ; 
		System.out.println(employeelist.toString()); 
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("username") ; 
		String password = request.getParameter("password") ; 
		PrintWriter pw =  response.getWriter(); 
		CheckLoginCredentials cs = new CheckLoginCredentials() ; 
		if(cs.checkLogin(employeelist, name, password)) {
			pw.write("Login Successfull" ) ; 
			HttpSession hs=request.getSession();
	 		hs.setAttribute("name", name);
	 		hs.setAttribute("employeeList" , employeelist) ; 
	 		boolean isAdmin = CheckAdmin.checkAdmin(employeelist, name) ; 
	 		//System.out.println(employeelist.toString());
	 		//System.out.println(isAdmin);
	 		if(isAdmin) {		//admin 
	 			System.out.println("if hai ");
	 			RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
				dispatcher.forward(request , response); 
	 		}
	 		else {	//employee 
	 			System.out.println("else hai ");
	 			  
	 			EmployeeDAO employeeData = CheckAdmin.getEmployeeDetails(employeelist, name) ; 
		 		hs.setAttribute("employeeData", employeeData ) ;
		 		System.out.println("ye hua ");
		 		RequestDispatcher dispatcher = request.getRequestDispatcher("employeePage.jsp");
				dispatcher.forward(request , response); 
	 		}
	 		
		}
		else{
			pw.write("You have Enter Wrong Credentials /n click here to  try again " ) ; 
		}
		
	}

}

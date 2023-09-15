package com.controller;

import java.io.IOException;
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
import com.service.UpdateEmploye;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userID = Integer.parseInt(request.getParameter("userID")) ; 
		
		HttpSession session = request.getSession() ; 
		
		
		List<EmployeeDAO> employeeList  = (List<EmployeeDAO>) session.getAttribute("employeeList") ; 
		//session.setAttribute("employeeList", employeeList);

		
		// jo employee update hoga uska data 
		EmployeeDAO updateEmployee=employeeList.stream().filter(e->e.getUserID() == userID).findFirst().orElse(null);
		
		
		
		session.setAttribute("updateEmployee", updateEmployee);
		employeeList.remove(updateEmployee) ;
		session.setAttribute("employeeList", employeeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updatePage.jsp");
		dispatcher.forward(request , response); 
	}

}

<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.Entity.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Update Employee Page</title>
</head>
<body>
	<%
	HttpSession hs=request.getSession();
	EmployeeDAO employeeData  = (EmployeeDAO) session.getAttribute("employeeData") ; 
	%>

  <div class="container">
  <h2>Update Employee</h2>
  <form action="updateEmp2" method="post">
  
    <div class="form-group">
      <label for="userid">UserID:</label>
      <input readonly class="form-control" id="userid" name="userid" value = <% out.print(employeeData.getUserID());  %> >
    </div>
    <div class="form-group">
      <label for="username">User Name:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter UserName" name="username" value = <% out.print(employeeData.getName());  %>>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" value = <% out.print(employeeData.getPassword());  %>>
    </div>
    <div class="form-group">
      <label for="Phone Number">Phone Number :</label>
      <input type="text" class="form-control" id="phoneNum" placeholder="Enter Phone Number :" name="phone" value = <% out.print(employeeData.getPhone_no() );   %>>
    </div>
    <div class="form-group">
      <label for="Designation">Designation  :</label>
      <input type="text" class="form-control" id="Designation" placeholder="Enter your Designation :" name="designation" value = <% out.print(employeeData.getDesignation() );   %>>
    </div>
    
    <button type="submit" name="submit" value="submit" class="btn btn-primary">Update</button>
  </form>
</div>


</body>
</html>
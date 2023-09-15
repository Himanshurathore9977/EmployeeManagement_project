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
<title>Update Page</title>
</head>
<body>
	<%
	HttpSession hs=request.getSession();
		 EmployeeDAO list  =(EmployeeDAO)hs.getAttribute("updateEmployee") ; 
	%>

  <div class="container">
  <h2>Update Employee</h2>
  <form action="update2" method="post">
  
    <div class="form-group">
      <label for="userID">UserID:</label>
      <input readonly class="form-control" id="userID" name="userid" value = <% out.print(list.getUserID());  %> >
    </div>
    <div class="form-group">
      <label for="username">User Name:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter UserName" name="username" value = <% out.print(list.getName());  %>>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" value = <% out.print(list.getPassword());  %>>
    </div>
    <div class="form-group">
      <label for="username">Phone Number :</label>
      <input type="text" class="form-control" id="phoneNum" placeholder="Enter Phone Number :" name="phone" value = <% out.print(list.getPhone_no() );   %>>
    </div>    
      <input type="radio" id="admin" name="isAdmin" value="admin">
  <label for="admin">is Admin</label><br>
  <input type="radio" id="notAdmin" name="isAdmin" value="notAdmin">
  <label for="notAdmin">Not Admin</label><br>
    <button type="submit" name="submit" value="submit" class="btn btn-primary">Login</button>
  </form>
</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.Entity.*" %>
    <%@ page import="com.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #ffffff;
        }
        h1 {
    		font-size: 36px; /* Adjust the font size as needed */
    		font-family: Arial, sans-serif; /* Specify the desired font and fallback fonts */
    		color: #	007bff; /* Choose your desired text color */
    		text-align: center; /* Center-align the text */
		}
       

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<% List<EmployeeDAO>EmployeeDetail = (List<EmployeeDAO>)session.getAttribute("employeeList"); %>

<h1>Admin Page </h1>

	<table class="table">
  <thead>
    <tr>
    	<th scope="col">#</th> 
      <th scope="col">Name</th>
      <th scope="col">UserID</th>
      <th scope="col">Designation </th> 
      <th scope="col">phone_no</th>
      <th scope="col">password</th>
    </tr>
  </thead>
  <tbody>  
	
    
    <% 
		for(int i=0 ; i<EmployeeDetail.size() ; i++){
	%>
	  <tr>
		<th scope="row"> <%= i+1 %> </th>	
		<td><%= EmployeeDetail.get(i).getName() %></td> 	
		<td><%= EmployeeDetail.get(i).getUserID() %></td> 
		<% String desg = EmployeeDetail.get(i).getDesignation() ; 
	%>
      	<td><%= desg %></td>
      	<td><%= EmployeeDetail.get(i).getPhone_no() %></td>
      	<td><%= EmployeeDetail.get(i).getPassword() %></td>
		<% 
		if(desg != null &&desg.equalsIgnoreCase("admin")){
		%>
		<td> Can't Delete Admin  </td>
		<td> Can't Update Admin  </td>  
		<% 
		}else{ %>
		<td> <form action="deleteServlets" method="post">
			
			<input type="hidden" id="fname" name="username" value=<%= EmployeeDetail.get(i).getUserID() %> >
			<button type="submit" name= "deleteServlets"  value="Submit">Delete</button>
			</form>
			
		<td> <form action="update" method="post">
			
			<input type="hidden" id="fname" name="userID" value=<%= EmployeeDetail.get(i).getUserID() %> >
			<button type="submit" name= "update"  value="Submit">Update</button>
			</form>	
		</td>
		<%	
		}
		%>
      	
      </tr>
	<%}%>
    
    
  </tbody>
  </table>
  <div align="center">
  <a class="btn btn-primary" href="addEmployee.jsp" role="button">Add Data</a>
  <br><br>
  </div>
           <div align="center">
           
  
  <a class="btn btn-danger" href="logout" role="button">Logout</a>
           </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.Entity.*" %>
<!DOCTYPE html>
<% List<EmployeeDAO>employeeData = (List<EmployeeDAO>)session.getAttribute("employeeData");%>
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
    </style>
<title>Insert title here</title>
</head>
<body>
	<table class="table">
  <thead>
    <tr>
    	<th scope="col">#</th> 
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">Designation </th> 
      <th scope="col">phone_no</th>
      <th scope="col">password</th>
    </tr>
  </thead>
  <tbody>  
	
    
    <% 
		for(int i=0 ; i<employeeData.size() ; i++){
	%>
	<tr>
		<th scope="row">  </th>	
		<td><%= employeeData.get(i).getName() %></td> 	
      	<td><%= employeeData.get(i).getUserID() %></td>
      	<td><%= employeeData.get(i).getDesignation() %></td>
      	<td><%= employeeData.get(i).getPhone_no() %></td>
      	<td><%= employeeData.get(i).getPassword() %></td>
               	</tr>
	<%}%>
    
    
  </tbody>
  </table>
  
  
</body>
</html>
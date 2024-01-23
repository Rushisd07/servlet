<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<jsp:useBean id="emp" class="com.demo.bean.EmployeeBean"> <!-- EmployeeBean emp = new EmployeeBean() -->
 <jsp:setProperty name="emp" param="empId" property = "empId"/><!--  setter method -->
 <jsp:setProperty name="emp" param="empName" property ="empName"/>
 <h2> id is </h2>
 <jsp:getProperty name="emp" property="empId"/><!--  getter method -->
 <jsp:getProperty name="emp" property="empName"/>
 ${emp.empName}
</jsp:useBean>
 </body>
</html>
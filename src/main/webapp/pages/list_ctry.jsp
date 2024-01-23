<%@ page language="java" import="java.sql.*,com.mysql.cj.jdbc.MysqlDataSource" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Countries</title>
</head>
<body>
<form>
	<select>
	<!-- JDBC Code -->
	<% 
		Connection conn;
		PreparedStatement prp;
		ResultSet rs;
		String qry ="select * from country";
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword("root");
		ds.setDatabaseName("rushi");
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		try {
			conn = ds.getConnection();
			prp = conn.prepareStatement(qry);
			rs = prp.executeQuery();
			while(rs.next()){
	%>
		<option><%= rs.getString(2) %></option>
		<% 
			}	//End of while block
		}	//End of try block
		catch(Exception e){
			e.printStackTrace();
		}
		%>
	</select>
</form>
</body>
</html>
package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;
//import com.util.GetMySQLConnection;

/**
 * Servlet implementation class AcceptStudData
 */
@WebServlet("/acceptstddata")
public class AcceptStudData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptStudData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String temp = "";
		//Capture data entered by the user
		String user = request.getParameter("user");
		String gender = request.getParameter("gender");
		
		String language[] = request.getParameterValues("subj");
		
		String state = request.getParameter("state");
		
		out.print("<html> Student Name is : "+user+"<br> Gender : "+gender+"<br>");
		//out.println("Entered subjects are : ");
			for(int i=0;i<language.length;i++)
				temp+=(language[i]+",");
			out.println("Entered subjects are : "+temp);
			//System.out.println(temp+",");
		out.println("<br> States is : "+state);
		
		
		//Connecting to DB through jdbc
		Connection conn;
		PreparedStatement prp;
		String qry ="Insert into student values(?,?,?,?)";
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword("root");
		ds.setDatabaseName("studentdata");
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		
		try {
			conn = ds.getConnection();
			prp = conn.prepareStatement(qry);
			//set IN parameter
			prp.setString(1, user);
			prp.setString(2, gender);
			prp.setString(3, temp);
			prp.setString(4, state);
			prp.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        
	}
}


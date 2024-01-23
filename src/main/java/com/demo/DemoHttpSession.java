package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoHttpSession
 */
@WebServlet("/session")
public class DemoHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoHttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Count of requests to the server
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//create a session object
		HttpSession session = request.getSession();
		out.println("Session ID is : "+session.getId());	//Returns the ID for opened browser
		
/*		SimpleScriptContext simple = new SimpleScriptContext(); 

	    // add some attribute using setAttribute() 
	    simple.setAttribute("Team1", "India", 
	                        ScriptContext.ENGINE_SCOPE); 
	    simple.setAttribute("Team2", "Japan", 
	                        ScriptContext.ENGINE_SCOPE); 
	    simple.setAttribute("Team3", "Nepal", 
	                        ScriptContext.ENGINE_SCOPE); 
	
	    // print 
	    System.out.println("Team1:"
	                       + simple.getAttribute("Team1")); 
	    System.out.println("Team2:"
	                       + simple.getAttribute("Team2")); 
	    System.out.println("Team3:"
	                       + simple.getAttribute("Team3")); 		
		*/
		
		if (session.isNew()) {//Checks whether the request is send from the browser for the first time
			//set the attributes
			session.setAttribute("count", 1);
			out.println("Request sent 1 time");			
		}
		else {	//When the request is sent from the same browser from 2nd time onwards
			//get the attributes value
			Integer c = (Integer)session.getAttribute("count");
			//Update the value of count
			++c;
			session.setAttribute("count",c);
			out.println("Request Sent "+c+" times");
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

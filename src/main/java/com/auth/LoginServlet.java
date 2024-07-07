package com.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
 
public class LoginServlet extends HttpServlet {
	 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter printWriter=response.getWriter();
		
		
	RequestDispatcher requestDispatcher=request.getRequestDispatcher("link.jsp");
	   
	requestDispatcher.include(request, response);
	
	 
	String uname=request.getParameter("name");
	String pass=request.getParameter("password");
	
	if (pass.equals("admin123")) {
		
		printWriter.print("You are successfully logged in!");  
		printWriter.print("<br>Welcome, "+uname);  
		
		
		Cookie cookie=new Cookie("name", uname);
		
		response.addCookie(cookie);
		
		
	}
	
	else
	{
		
		printWriter.print("sorry, username or password error!");  
		
		RequestDispatcher requestDispatcher2=request.getRequestDispatcher("login.jsp");
		requestDispatcher2.include(request, response);
				
	}
	
		printWriter.close();
		
	}

}

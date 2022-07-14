package com.cdac.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet") //url pattern
public class HelloServlet extends HttpServlet { 
	//servlet is a java program which understand http protocol..
	//with the help of browser we run servlet code using http protocol 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.write("<html><body>");
		out.write("<h1>Hello Again<h1>");
		out.write("<h2>today date is"+ LocalDate.now()+ "<h2>");
		out.write("</body></html>");
		
		
	}

	

}

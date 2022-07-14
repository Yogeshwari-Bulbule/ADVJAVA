package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/As1")
public class assignment1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	    int result = 0;
	    String str = null;
	    if(request.getParameter(("Add")) != null)
          {
	           result = num1 + num2;
	           str = "Addition result";
	           
         }
          else if(request.getParameter(("sub"))!= null)
          {
	           result = num1 - num2;
	           str = "Subtraction result";
	           
          } 
          else if(request.getParameter(("muliply")) != null)
        	  
          {
	           result = num1 * num2;
	           str = "Multiplication result";
	           
          } 
	    
          else if(request.getParameter(("divide")) != null)
        		  {
	           result = num1 /num2;
	           str = "Division result";
	           
               } 
          
          response.setContentType("text/html");
  	    PrintWriter  out = response.getWriter();
  	    out.write("<html><body>");
  	    out.write("<h1>"+"str:"+result+"</h1");
  	    out.write("</body></html>");
	   
	}
}
	    
	    
	    	
	    
	    		
	    
	    	
	    
	
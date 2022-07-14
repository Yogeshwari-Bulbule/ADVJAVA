package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.RegisterLogic;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.cdac")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long mobileno = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterLogic registerLogic = new RegisterLogic();
		boolean alreadyRegistered = registerLogic.isStudentPresent(email);
		if (alreadyRegistered) {
			out.write("<head><body>");
			out.write("<h1>Already Registered</h1>");
			out.write("</body></head>");
		} else {
			boolean registered = registerLogic.registerStudent(name, email, mobileno, username, password);
			if (registered) {
				out.write("<head><body>");
				out.write("<h1>Student Registered</h1>");
				out.write("</body></head>");
			} else {
				out.write("<head><body>");
				out.write("<h1>Student not Registered</h1>");
				out.write("</body></head>");
			}
		}
		
	}

}

package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.cdac")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean isValid = loginService.loginCheck(username, password);
		
		if (isValid) {
			String rememberMe = request.getParameter("rememberMe");
			if (rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", username);
				Cookie c2 = new Cookie("upass", password);
				
				c1.setMaxAge(60 * 60);
				c2.setMaxAge(60 * 60);
				
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		} else {
			response.sendRedirect("login.html");
		}
	}

}

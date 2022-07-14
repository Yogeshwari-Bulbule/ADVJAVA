package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.service.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.cdac")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		
		HttpSession session = request.getSession();
		String enteredCaptcha = (String)session.getAttribute("curCaptcha");
		
		boolean cpCheck = captcha.equals(enteredCaptcha);
		
		LoginLogic loginLogic = new LoginLogic();
		boolean check = loginLogic.isCheck(username, password);
		if (check && cpCheck) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", username);
				c1.setMaxAge(60 * 30);
				Cookie c2 = new Cookie("upass", password);
				c2.setMaxAge(60 * 30);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			
			response.sendRedirect("welcome.html");
		} else {
			response.sendRedirect("register.html");
		}
	}

}

package com.cdac.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.LoginService;


@WebServlet("/login2.cdac")
public class loginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");  //to read data -request.getParameter
		String password = request.getParameter("password");

		LoginService loginService = new LoginService();  //create obj of loginservice class this class crete in package com.cdac.service.LoginService;
		
		boolean isValid = loginService.loginCheck(username, password);  //loginCheck is method in loginservice class(using obj we call a method) this value stored in isvalid variable
		
		if(isValid) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", username);
				c1.setMaxAge(60 * 60 * 24);
				Cookie c2 = new Cookie("upass", password);
				c2.setMaxAge(60 * 60 * 24);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
		
	}

}

	
	
	
	
	
	
	

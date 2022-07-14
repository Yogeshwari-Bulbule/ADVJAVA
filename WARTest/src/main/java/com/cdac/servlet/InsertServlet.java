package com.cdac.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.EmployeeDao;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/AddEmployeeServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(empno, name, salary, doj);
		
		response.setContentType("text/html");
		response.sendRedirect("success.html");
		
	}

}

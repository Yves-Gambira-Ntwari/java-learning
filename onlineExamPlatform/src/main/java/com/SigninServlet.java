package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("section1.html").forward(request, response);
		String studentId = request.getParameter("studentId");
		String examId = request.getParameter("examId");
		
		if(studentId.equals("STU12345") && examId.equals("EXAM6789")){			
			request.getRequestDispatcher("section1.html").forward(request, response);
		}else {
			System.out.print("Try again the username or password is incorect");
			response.getWriter().append("<h1>Try again the username or password is incorect<h1>");
		}
	}

}

package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnswerCheckerServlet
 */
@WebServlet("/AnswerCheckerServlet")
public class AnswerCheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score = 0;
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		String q4 = request.getParameter("q4");
		String q5 = request.getParameter("q5");
		String q6 = request.getParameter("q6");
		String q7 = request.getParameter("q7");
		String q8 = request.getParameter("q8");
		if("B".equals(q1)) score++;
		if("A".equals(q2)) score++;
		if("B".equals(q3)) score++;
		if("B".equals(q3)) score++;
		if("C".equals(q4)) score++;
		if("B".equals(q5)) score++;
		if("B".equals(q6)) score++;
		if("B".equals(q7)) score++;
		if("B".equals(q8)) score++;
		if(score <=5) {			
		System.out.print(score + "you've failed the test");
		response.getWriter().append("<h1 style'color: red'>you've failed the test<h1>");
		}else {			
			System.out.print(score + "you've passed the test");
			response.getWriter().append("<h1 style'color: green'>you've passed the test<h1>");
		}
		
	}
	

}

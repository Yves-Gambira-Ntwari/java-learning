package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String namesList[] = {"gambira", "Eric", "dosite", "sarah", "kevine", "Yves"};
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		response.getWriter().append("username" + username);
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		boolean found = false;
		for(String name: namesList) {
			if(name.equals(username)) {
				found = true;
				break;
			}
		}
		if(found) {
			
//			response.getWriter().append("username: " + username +" found in names list");
			request.getRequestDispatcher("/ResealtServlet").forward(request, response);
			} else {
//				response.getWriter().append("username: " + username + " not found in names list");
				request.getRequestDispatcher("/NoresearltServlet").forward(request, response);
			}
		
	}
	

}

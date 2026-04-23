package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("webcontent/orders.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemName = request.getParameter("itemName");
		String category = request.getParameter("category");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String purchaseDate = request.getParameter("purchaseDate");
		String supplier = request.getParameter("supplier");
		DBConnection db = new DBConnection();
		
		Boolean insert = db.InsertOrder(itemName, category, quantity, price, purchaseDate, supplier);
		if(insert) {
			response.sendRedirect("home");
		}else {
			response.getWriter().println("Insert Error");
		}
	}

}

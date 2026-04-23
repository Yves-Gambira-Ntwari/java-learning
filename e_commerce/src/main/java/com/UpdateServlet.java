package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.print(id);
		DBConnection db = new DBConnection();
		PurchaseWithId purchase = db.getPurchaseWithId(id);
		if (purchase == null) {
		    request.setAttribute("error", "Item not found");
		    request.getRequestDispatcher("webcontent/error.jsp").forward(request, response);
		    return;
		}
		request.setAttribute("purchaseUpdate", purchase);
		request.getRequestDispatcher("webcontent/update.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String itemName = request.getParameter("itemName");
		String category = request.getParameter("category");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String purchaseDate = request.getParameter("purchaseDate");
		String supplier = request.getParameter("supplier");
		DBConnection db = new DBConnection();
		Boolean update = db.UpdatePurchase(itemName, category, quantity, price, purchaseDate, supplier, id);
		if(update) {
			response.sendRedirect("home");
		}
		
	}
	

}

package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer cmb1 = Integer.valueOf((String) request.getParameter("c1"));
		Integer cmb2 = Integer.valueOf((String) request.getParameter("c2"));
		Integer cmb3 = Integer.valueOf((String) request.getParameter("c3"));
		if (cmb1 + cmb2 + cmb3 == 0) {
			throw new Error("No item ordered");
		}
		HashMap<String, Integer> orders = new HashMap<>();
		orders.put("c1", cmb1);
		orders.put("c2", cmb2);
		orders.put("c3", cmb3);

		request.setAttribute("orders", orders);
		request.getRequestDispatcher("calculate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
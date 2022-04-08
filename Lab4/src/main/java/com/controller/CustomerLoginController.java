package com.controller;

import java.io.IOException;

import com.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.model.*;

public class CustomerLoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String cusID = request.getParameter("customer_id");
			String password = request.getParameter("customer_pwd");
//			System.out.println(cusID);
//			System.out.println(password);
			UserDAO userDAO = new UserDAO();
			Customer customer = userDAO.getCustomer(cusID, password);
			
			HttpSession session = request.getSession();
			
			if (customer != null) {
				session.setAttribute("customer", customer);
				RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("customer", "not_found");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}

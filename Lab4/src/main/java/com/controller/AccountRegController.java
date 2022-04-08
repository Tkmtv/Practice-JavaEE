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

public class AccountRegController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			Customer cus = (Customer) session.getAttribute("customer");
			
			String customer_id = request.getParameter("customer_id");
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_id");
			String user_name = request.getParameter("u_name");
			String address = request.getParameter("u_address");
			String phone = request.getParameter("u_phone");
			String user_type = request.getParameter("u_type");
			String user_number = user_id;
			
			UserDAO userDAO = new UserDAO();
			if (user_type.equalsIgnoreCase("saving")) {
				double balance = Double.valueOf(request.getParameter("u_balance"));
				int duration = Integer.valueOf(request.getParameter("u_duration"));
				double rate = Double.valueOf(request.getParameter("u_rate"));
				userDAO.registAccount(customer_id, user_id, user_password, user_name, address, phone, user_type, user_number);
				userDAO.registSaving(user_id, balance, rate, duration);
			} else {
				double balance = Double.valueOf(request.getParameter("u_balance"));
				userDAO.registAccount(customer_id, user_id, user_password, user_name, address, phone, user_type, user_number);
				userDAO.registCurrent(user_id, balance);
			}
			session.setAttribute("customer", cus);
			RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}

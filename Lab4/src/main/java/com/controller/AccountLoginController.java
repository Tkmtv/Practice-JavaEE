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

public class AccountLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Customer cus = (Customer) session.getAttribute("customer");

			String u_name = request.getParameter("u_name");
			String password = request.getParameter("u_pwd");

			UserDAO userDAO = new UserDAO();
			UserAccount account = new CurrentAccount();
			account = userDAO.getCurrentAccount(u_name, password);
			if (account == null) {
				userDAO = new UserDAO();
				account = new SavingAccount();
				account = userDAO.getSavingAccount(u_name, password);
			}
			if (account != null) {
				System.out.println("found");
				session.setAttribute("account", account);
				session.setAttribute("customer", cus);
				RequestDispatcher rd = request.getRequestDispatcher("currentAcc.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("not found");
				session.setAttribute("account", "not_found");
				session.setAttribute("customer", cus);
				RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
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

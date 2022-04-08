package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.model.*;

public class TransferController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			
			Customer cus = (Customer) session.getAttribute("customer");
			UserAccount account = (UserAccount) session.getAttribute("account");

			String sender = account.getUser_id();
			double senderBalance = account.getCurrentBalance();
			String receiver = request.getParameter("receiver");
			String r_type = request.getParameter("r_type");
			double amount = Double.valueOf(request.getParameter("amount"));
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String date = String.valueOf(ft.format(new Date()));
			if (senderBalance < 10000000 && account.getAccount_type().equals("current")) {
				senderBalance -= 50000;
			}
			if (senderBalance < amount) {
				throw new Error("Not enough money");
			} else {
				senderBalance -= amount;
			}
			UserDAO userDAO = new UserDAO();
			double receiverBalance = amount;
			if (r_type.equals("saving")) {
				receiverBalance += userDAO.checkSavingAccountBalance(receiver);
			} else {
				receiverBalance += userDAO.checkCurrentAccountBalance(receiver);
			}
			userDAO = new UserDAO();
			if (account.getAccount_type().equals("saving")) {
				userDAO.transferFromSaving(sender, senderBalance, receiver, receiverBalance, r_type, amount, date);
				userDAO = new UserDAO();
				account = userDAO.getSavingAccount(account.getUser_name(), account.getUser_password());
			} else {
				userDAO.transferFromCurrent(sender, senderBalance, receiver, receiverBalance, r_type, amount, date);
				userDAO = new UserDAO();
				account = userDAO.getCurrentAccount(account.getUser_name(), account.getUser_password());
			}
			
			session.setAttribute("customer", cus);
			session.setAttribute("account", account);
			RequestDispatcher rd = request.getRequestDispatcher("currentAcc.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}

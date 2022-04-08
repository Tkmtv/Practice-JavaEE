package com.cse456.lab5.controller;

import com.cse456.lab5.entities.*;
import com.cse456.lab5.provider.FactoryProvider;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteStoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Story story = null;
			String type = (String) request.getParameter("cakeType");

			
			//session.setAttribute("order", order);
			s.save(story);
			tx.commit();
			s.close();
			response.sendRedirect("bill.jsp");
		} catch (Exception e) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
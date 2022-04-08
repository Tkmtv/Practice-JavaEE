package com.cse456.lab5.controller;

import com.cse456.lab5.entities.*;
import com.cse456.lab5.provider.FactoryProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewStoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Story story = null;
			String mail = (String) request.getParameter("mail");
			String sql = "SELECT email_id FROM story where email_id = '"+ mail + "';";
			SQLQuery query = s.createSQLQuery(sql);
			query.addEntity(Employee.class);
			List results = query.list();
//			Story res = (Story) s.get(Story.class, mail);
//			tx.commit();
			System.out.println(query.getResultList() );
			
//			if (res == null) {
//				session.setAttribute("mail", "not_found");
//				response.sendRedirect("OldStory.jsp");
//			} else {
//				session.setAttribute("mail", mail);
//				Query query = s.createQuery("SELECT * FROM story;");
//		        s.getTransaction().commit();
//				ArrayList<Story> stories = (ArrayList<Story>) query.getResultList();
//				session.setAttribute("stories", stories);
//				response.sendRedirect("ViewStory.jsp");
//			}
//			
			
			s.close();
		} catch (Exception e) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
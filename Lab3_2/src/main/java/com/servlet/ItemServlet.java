package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import com.data.*;

public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Combo> combos = new ArrayList<Combo>();

		Item chicken = new Item("Chicken Bucket", 100000, "./Resource/chicken.jpg");
		Item burger = new Item("Burger", 70000, "./Resource/burger.jpg");
		Item pizza = new Item("Pizza", 100000, "./Resource/pizzza.jpg");
		Item pepsi = new Item("Pepsi", 30000, "./Resource/pepsi.jpg");

		List<Item> comboItems1 = new ArrayList<>();
		comboItems1.add(chicken);
		comboItems1.add(pepsi);
		combos.add(new Combo("c1", "Combo_1", 0.1, comboItems1));
		
		List<Item> comboItems2 = new ArrayList<>();
		comboItems2.add(chicken);
		comboItems2.add(pizza);
		comboItems2.add(pepsi);
		combos.add(new Combo("c2", "Combo_2", 0.15, comboItems2));
		
		List<Item> comboItems3 = new ArrayList<>();
		comboItems3.add(chicken);
		comboItems3.add(burger);
		comboItems3.add(pizza);
		comboItems3.add(pepsi);
		combos.add(new Combo("c3", "Combo_3", 0.2, comboItems3));

		HttpSession session = request.getSession();
		session.setAttribute("combos", combos);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
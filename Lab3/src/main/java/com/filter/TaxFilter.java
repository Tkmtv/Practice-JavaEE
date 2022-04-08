package com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;

public class TaxFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		try {
			double finalAmount = Double.valueOf((String) req.getParameter("finalAmount"));
			double initialBalance = Double.valueOf((String) req.getParameter("initialBalance"));
			
			if (finalAmount > 10000000) {
				initialBalance += initialBalance * (2.5 / 100);
			} else {
				initialBalance += initialBalance * (1.25 / 100);
			}
			
			req.setAttribute("initialBalance", initialBalance);	
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		chain.doFilter(req, res);
	}

}

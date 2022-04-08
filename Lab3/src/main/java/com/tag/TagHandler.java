package com.tag;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	private double finalAmount;
	private double initialBalance;
	private double interestRate;
	private double numberInterest;
	private double numberPeriods;

	public double getFinalAmount() {
		return finalAmount;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getNumberInterest() {
		return numberInterest;
	}

	public double getNumberPeriods() {
		return numberPeriods;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100;
	}

	public void setNumberInterest(double numberInterest) {
		this.numberInterest = numberInterest;
	}

	public void setNumberPeriods(double numberPeriods) {
		this.numberPeriods = numberPeriods;
	}

	public double calculateInterest(double initialBalance, double interestRate, double numberInterest, double numberPeriods) {

		double base = (1 + ((interestRate) / numberInterest));

		double result = initialBalance * Math.pow(base, numberPeriods);
		return result;
	}

	public int doStartTag() throws JspException {
		try {
			
			JspWriter out = pageContext.getOut();
				
			double compound = calculateInterest(initialBalance, interestRate, numberInterest, numberPeriods);
			compound = Math.round(compound * 100.0) / 100.0;
			
			out.println("<p style='text-align:center;'>#################################</p>");
			out.println("<h3 style='text-align:center;'>The compund interest</h3>");
			out.println("<h4 style='text-align:center;'>" + compound + "</h4>");

			out.println("<p style='text-align:center;'>#################################</p>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SKIP_BODY;
	}

}

package com.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	private long finalAmount;
	private long initialBalance;
	private long interestRate;
	private long numberInterest;
	private long numberPeriods;

	public long getFinalAmount() {
		return finalAmount;
	}

	public long getInitialBalance() {
		return initialBalance;
	}

	public long getInterestRate() {
		return interestRate;
	}

	public long getNumberInterest() {
		return numberInterest;
	}

	public long getNumberPeriods() {
		return numberPeriods;
	}

	public void setFinalAmount(long finalAmount) {
		this.finalAmount = finalAmount;
	}

	public void setInitialBalance(long initialBalance) {
		this.initialBalance = initialBalance;
	}

	public void setInterestRate(long interestRate) {
		this.interestRate = interestRate;
	}

	public void setNumberInterest(long numberInterest) {
		this.numberInterest = numberInterest;
	}

	public void setNumberPeriods(long numberPeriods) {
		this.numberPeriods = numberPeriods;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			double base = (1 + ((interestRate / 100) / numberInterest));
			double exponent = numberInterest * numberPeriods;

			long compound = (long) (initialBalance * Math.pow(base, exponent));

			pageContext.setAttribute("compoundTest", String.valueOf(compound));
//			print the compound interest

			out.println("<p style='text-align:center;'>#################################</p>");
			out.println("<h3 style='text-align:center;'>The compund interest before tax</h3>");
			out.println("<h4 style='text-align:center;'>" + compound + "</h4>");

			out.println("<p style='text-align:center;'>#################################</p>");
			out.println("<h3 style='text-align:center;'>The compund interest after tax</h3>");
			out.println("<h4 style='text-align:center;'>" + compound + "</h4>");

			out.println("<h4 style='text-align:center;'>" + finalAmount + "</h4>");
			out.println("<h4 style='text-align:center;'>" + initialBalance + "</h4>");
			out.println("<h4 style='text-align:center;'>" + interestRate + "</h4>");
			out.println("<h4 style='text-align:center;'>" + numberInterest + "</h4>");
			out.println("<h4 style='text-align:center;'>" + numberPeriods + "</h4>");
			out.println("<h4 style='text-align:center;'>" + base + "</h4>");
			out.println("<h4 style='text-align:center;'>" + exponent + "</h4>");
			out.println("<h4 style='text-align:center;'>" + compound + "</h4>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SKIP_BODY;
	}

}

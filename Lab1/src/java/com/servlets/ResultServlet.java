package com.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws
            IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String rollNumber = req.getParameter("rollNumber");
        String dob = req.getParameter("dob");
        //validate
        if (rollNumber.equals("123456") && dob.equals("01/01/2022")) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Lab 1</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link rel='stylesheet' href='./CSS/Style.css'/>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div>");
            out.print("<ul>");
            out.print("<li>");
            out.print("Roll number: " + rollNumber);
            out.print("</li>");
            out.print("<li>");
            out.print("Name: Alexander Martin");
            out.print("</li>");
            out.print("<li>");
            out.print("Grade: C+");
            out.print("</li>");
            out.print("</ul>");
            out.print("</div>");
        } else {
            out.print("<div class='prompt'>");
            out.print("You have entered wrong roll number "
                    + "or date of birth. Please fill correct data");
            out.print("</div>");
            RequestDispatcher rd = req.getRequestDispatcher("result.html");
            rd.include(req, res);
        }
    }
}

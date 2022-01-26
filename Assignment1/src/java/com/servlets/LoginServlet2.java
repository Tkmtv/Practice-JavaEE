package com.servlets;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet2 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws 
            ServletException, IOException {

        //Set the content-Type of the response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        //validate
        if (name.equals("Hieu") && password.equals("Hieu123")) {
            out.print("<head>");
            out.print("<title>Lab 1</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link rel='stylesheet' href='./CSS/Style.css'/>");
            out.print("</head>");
            out.print("<div class='prompt'>");
            out.print("Welcome to Advance Java programming Course...");
            out.print("</div>");
        } else {
            out.print("<div class='prompt'>");
            out.print("You have entered wrong username "
                    + "or password. Please try again...");
            out.print("</div>");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
    }

}

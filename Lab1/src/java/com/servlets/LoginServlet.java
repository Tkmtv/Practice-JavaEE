package com.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws
            IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        //validate
        if (name.equals("Hieu") && password.equals("Hieu123")) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Lab 1</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link rel='stylesheet' href='./CSS/Style.css'/>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='prompt'>");
            out.print("Welcome to Advance Java programming Course...");
            out.print("</div>");
        } else {
            out.print("<div class='prompt'>");
            out.print("You have entered wrong username "
                    + "or password. Please try again...");
            out.print("</div>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        }
    }
}

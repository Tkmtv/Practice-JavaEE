package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet1 implements Servlet {

    //Life cycle method
    ServletConfig conf;

    //Override init() method
    @Override
    public void init(ServletConfig sc) throws ServletException {
        this.conf = conf;
        System.out.println("Creating Object:.......");
    }

    //Non-Life cycle method
    //Override getServletConfig() method
    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    //Override service() method
    @Override
    public void service(ServletRequest req, ServletResponse res) throws
            ServletException, IOException {

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

    //Override getServletInfo() method
    @Override
    public String getServletInfo() {
        return "This servlet is created by Tin Nguyen";
    }

    //Override destroy() method
    @Override
    public void destroy() {
        System.out.println("Servlet Object is going to destroy....");
    }

}

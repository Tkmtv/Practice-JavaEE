package com.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws
            IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String uname = req.getParameter("user_name");
        String password = req.getParameter("pwd");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        PrintWriter out = res.getWriter();

        String isAgree = req.getParameter("condition");
        //validate
        if (isAgree != null && isAgree.equals("checked")) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Lab 1</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link rel='stylesheet' href='./CSS/Style.css'/>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='prompt'>");
            out.print("Welcom to Register Servlet");
            out.print("</div>");
            out.print("<div>");
            out.print("Hi " + name + ". You are successfuly registed in this java course");
            out.print("</div>");
            out.print("<div>");
            out.print("Your detail are given below");
            out.print("<ul>");
            out.print("<li>");
            out.print("Name: " + name);
            out.print("</li>");
            out.print("<li>");
            out.print("User_name: " + uname);
            out.print("</li>");
            out.print("<li>");
            out.print("Password: " + password);
            out.print("</li>");
            out.print("<li>");
            out.print("Gender: " + gender);
            out.print("</li>");
            out.print("<li>");
            out.print("Course: " + course);
            out.print("</li>");
            out.print("</ul>");
            out.print("</div>");

        } else {
            out.print("<div class='prompt'>");
            out.print("Sorry! you have not accepted terms and condition");
            out.print("</div>");
            RequestDispatcher rd = req.getRequestDispatcher("register.html");
            rd.include(req, res);
        }
    }
}

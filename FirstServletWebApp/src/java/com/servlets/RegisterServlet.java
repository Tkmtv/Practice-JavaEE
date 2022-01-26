/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author takam
 */
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
            IOException {
        System.out.println("This is post method...");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Welcome to Register Servlet</h2>");
        String name = req.getParameter("name");
        String user_name = req.getParameter("user_name");
        String pwd = req.getParameter("pwd");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String condition = req.getParameter("condition");

        if (condition != null) {
            if (condition.equals("checked")) {
                out.println("<h2>Name:" + name + "</h2>");
                out.println("<h2>User_Name:" + user_name + "</h2>");
                out.println("<h2>Password:" + pwd + "</h2>");
                out.println("<h2>Gender:" + gender + "</h2>");
                out.println("<h2>Course:" + course + "</h2>");
            } else {
                out.println("<h2>Sorry! you have not accepted terms and conditions.</h2>");
            }
        } else {
            out.println("<h2>Sorry! you have not accepted terms and conditions.</h2>");

        }
    }
}

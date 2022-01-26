/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author takam
 */
public class FirstServlet implements Servlet {

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
        System.out.println("Servicing:......");
        //Set the content-Type of the response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my output from servlet method</h1>");
        out.println("<h1>Today's Date & Time : " + new Date().toString() + "</h1>");
    }

    //Override getServletInfo() method
    @Override
    public String getServletInfo() {
        return "This servlet is created by Debarshi Mazumder";
    }

    //Override destroy() method
    @Override
    public void destroy() {
        System.out.println("Servlet Object is going to destroy....");
    }

}

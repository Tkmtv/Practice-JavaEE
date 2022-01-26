/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SecondServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException,
            IOException {

        System.out.println("SecondServlet Servicing:......");
        //Set the content-Type of the response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my output from SecondServlet method using GenericServlet</h1>");
        out.println("<h1>Today's Date & Time : "+new Date().toString()+"</h1>");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author takam
 */
public class ThirdServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        PrintWriter out = res.getWriter();
        if (age >= 18) {
            res.sendRedirect("Register.html");
        } else {
            System.out.println();
            out.println("Hii..." + name + ". You are not elegible for vote");
        }
    }

}

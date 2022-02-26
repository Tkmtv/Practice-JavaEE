package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.system.DatabaseConnection;

public class LoginServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String username = request.getParameter("uname");
            String password = request.getParameter("pwd");
            System.out.println(username);

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement sta = con.createStatement();
            String query = "Select password from student_info where User_name='" + username + "'";
            ResultSet rs = sta.executeQuery(query);
            boolean flag = false;
            while (rs.next()) {
                String pass = rs.getString("password");

                if (password.equals(pass)) {
                    flag = true;
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect("result.jsp");
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("WrongUser.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

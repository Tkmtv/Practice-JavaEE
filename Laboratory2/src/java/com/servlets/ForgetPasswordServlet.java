package com.servlets;

import com.system.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ForgetPasswordServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String email = request.getParameter("email_f");
            System.out.println(email);

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement sta = con.createStatement();
            String query = "select email from student_info where email='" + email + "'";
            ResultSet rs = sta.executeQuery(query);
            boolean flag = false;
            while (rs.next()) {
                String mail = rs.getString("email");
                System.out.println(mail);
                if (email.equals(mail)) {
                    flag = true;
                    response.sendRedirect("EmailSuccess.jsp");
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("WrongEmail.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

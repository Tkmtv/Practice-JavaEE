package com.servlets;

import com.system.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String rollNumber = request.getParameter("rollnumb_r");
            String uname = request.getParameter("uname_r");
            String pwd = request.getParameter("pwd_r");
            String pwdCofirm = request.getParameter("pwd_c");
            String email = request.getParameter("email_r");

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement sta = con.createStatement();
            String query = "Select Roll from student_result where Roll='" + rollNumber + "'";
            ResultSet rs = sta.executeQuery(query);
            boolean flag = false;
            while (rs.next()) {
                String roll = rs.getString("Roll");

                if (rollNumber.equals(roll)) {
                    
                    try {
                        Statement st = con.createStatement();

			query = "insert into student_info values(?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, roll);
			pstmt.setString(2, uname);
			pstmt.setString(3, uname);
			pstmt.setString(4, pwd);
			pstmt.setString(5, email);
                        int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
                                response.sendRedirect("RegisterSuccess.jsp");
			}
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("RegisterError.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

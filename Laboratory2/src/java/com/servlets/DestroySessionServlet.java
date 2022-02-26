
package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DestroySessionServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            HttpSession session = request.getSession(false);
            try {
                session.invalidate();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                response.sendRedirect("index.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.system.DatabaseConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author takam
 */
public class ResultServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");

            ServletContext sc = getServletContext();
            String header = sc.getInitParameter("Header");
            String footer = sc.getInitParameter("Footer");

            String roll = request.getParameter("rollNum");
            String quatre = request.getParameter("quatre");
            String year = request.getParameter("year");

            System.out.println(roll);

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            String query = "select a.name, b.* from student_result b join student_info a on a.roll = b.roll where b.roll = '"
                    + roll + "';";
            ResultSet rs = st.executeQuery(query);
            boolean flag = false;
            while (rs.next()) {
                String nameBD = rs.getString("name");
                String rollBD = rs.getString("roll");
                String quatreBD = rs.getString("quatre");
                String yearBD = rs.getString("year");

                if (roll.equals(rollBD)) {
                    flag = true;
                    String course1 = rs.getString("course1");
                    String course2 = rs.getString("course2");
                    String course3 = rs.getString("course3");
                    String course4 = rs.getString("course4");

                    String grade1 = rs.getString("grade1");
                    String grade2 = rs.getString("grade2");
                    String grade3 = rs.getString("grade3");
                    String grade4 = rs.getString("grade4");
                    out.print("<!DOCTYPE html>"
                            + "<html>"
                            + "<head>"
                            + "<title>result success</title>"
                            + "<meta charset=\"UTF-8\">"
                            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                            + "<link href=\'https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\' rel=\'stylesheet\'"
                            + "integrity=\'sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\' crossorigin=\'anonymous\'>"
                            + "<link rel=\"stylesheet\" href=\"css/style.css\">"
                            + "<script type=\"text/javascript\" src=\"js/script.js\"></script>"
                            + "</head>"
                            + "<body>"
                            + "<header>"
                            + "<div>"
                            + header
                            + "</div>"
                            + "</header>"
                            + "<div class=\'container-fluid h-100\'>"
                            + "<div class=\"row align-items-start justify-content-center h-50\">"
                            + "<div class=\"table-responsive\">"
                            + "<table class=\"table table-bordered\">"
                            + "<tbody>"
                            + "<tr>"
                            + "<td colspan=\"1\">Name</td>"
                            + "<td colspan=\'4\' class=\"leftTD\">" + nameBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Roll</td>"
                            + "<td colspan=\"4\" class=\"leftTD\">" + rollBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Year</td>"
                            + "<td colspan=\"4\" class=\"leftTD\">" + yearBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Quatre</td>\""
                            + "<td colspan=\"4\" class=\"leftTD\">" + quatreBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Course</td>"
                            + "<td colspan=\"1\">" + course1 + "</td>"
                            + "<td colspan=\"1\">" + course2 + "</td>"
                            + "<td colspan=\"1\">" + course3 + "</td>"
                            + "<td colspan=\"1\">" + course4 + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Grade</td>"
                            + "<td colspan=\"1\">" + grade1 + "</td>"
                            + "<td colspan=\"1\">" + grade2 + "</td>"
                            + "<td colspan=\"1\">" + grade3 + "</td>"
                            + "<td colspan=\"1\">" + grade4 + "</td>"
                            + "</tr>"
                            + "</tbody>"
                            + "</table>"
                            + "</div>"
                            + "</div>"
                            + "<div class=\"row align-items-start justify-content-center\">"
                            + "<form id=\"return\" action=\"destroySession\" method=\"post\">"
                            + "<div class=\"mx-auto blk\">"
                            + "<button class=\"greenBtn\" type=\"submit\" name=\"return\">"
                            + "<span>"
                            + "Back"
                            + "</span>"
                            + "</button>"
                            + "<div>"
                            + "</form>"
                            + "</div>"
                            + "</div>"
                            + "<footer>"
                            + "<div>"
                            + footer
                            + "</div>"
                            + "</footer>"
                            + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\""
                            + "integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\""
                            + "crossorigin=\"anonymous\"></script>"
                            + "</body>"
                            + "</html>");
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("ResultError.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

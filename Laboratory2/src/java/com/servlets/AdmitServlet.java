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

public class AdmitServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String roll = request.getParameter("roll_a");

            ServletContext sc = getServletContext();
            String header = sc.getInitParameter("Header");
            String footer = sc.getInitParameter("Footer");

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement stCourses = con.createStatement();
            String query = "select a.name, b.* from student_result b join student_info a on a.roll = b.roll where b.roll = '"
                    + roll + "';";
            ResultSet rs = stCourses.executeQuery(query);
            boolean flag = false;

            while (rs.next()) {
                String nameBD = rs.getString("name");
                String rollBD = rs.getString("roll");
                String quatreBD = rs.getString("quatre");
                String yearBD = rs.getString("year");
                String[] courses = new String[5];
                String[] dates = new String[5];
                if (roll.equals(rollBD)) {
                    flag = true;
                    Statement stDates = con.createStatement();
                    for (int i = 1; i < 5; i++) {
                        courses[i] = rs.getString("Course" + i);
                        query = "select date from exam where Course ='" + courses[i] + "'";
                        System.out.println(query);

                        ResultSet courseSet = stDates.executeQuery(query);
                        if (courseSet.next()) {
                            dates[i] = courseSet.getString("date");
                        }
                    }
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
                            + "<div class=\"container-fluid\">"
                            + "<div class=\"row align-items-center dataContent\">"
                            + "<table border=\"1\" class=\"table table-bordered\">"
                            + "<thead>"
                            + "<tr>"
                            + "<th colspan=\"6\">Admit Card</th>"
                            + "</tr>"
                            + "</thead>"
                            + "<tbody>"
                            + "<tr>"
                            + "<td colspan=\"1\">Name</td>"
                            + "<td colspan=\"5\" class=\"leftTD\">" + nameBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Roll</td>"
                            + "<td colspan=\"1\">" + rollBD + "</td>"
                            + "<td colspan=\"1\">Year</td>"
                            + "<td colspan=\"1\">" + yearBD + "</td>"
                            + "<td colspan=\"1\">Quatre</td>"
                            + "<td colspan=\"1\">" + quatreBD + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Course</td>"
                            + "<td colspan=\"1\">" + courses[1] + "</td>"
                            + "<td colspan=\"1\">" + courses[2] + "</td>"
                            + "<td colspan=\"1\">" + courses[3] + "</td>"
                            + "<td colspan=\"1\">" + courses[4] + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Exam Date</td>"
                            + "<td colspan=\"1\">" + dates[1] + "</td>"
                            + "<td colspan=\"1\">" + dates[2] + "</td>"
                            + "<td colspan=\"1\">" + dates[3] + "</td>"
                            + "<td colspan=\"1\">" + dates[4] + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Candidate Signature</td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"1\">Invigilator Signature</td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "<td colspan=\"1\"></td>"
                            + "</tr>"
                            + "</tbody>"
                            + "</table>"
                            + "</div>"
                            + "<div class=\"row align-items-center\">"
                            + "<form id=\"return\" action=\"destroySession\" method=\"post\">"
                            + "<button class=\"greenBtn\" type=\"submit\" name=\"return\">"
                            + "<span>"
                            + "Back"
                            + "</span>"
                            + "</button>"
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
                response.sendRedirect("admitCardError.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

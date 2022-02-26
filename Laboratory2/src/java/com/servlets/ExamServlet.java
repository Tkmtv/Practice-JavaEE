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
import java.util.ArrayList;

public class ExamServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");

            ServletContext sc = getServletContext();
            String header = sc.getInitParameter("Header");
            String footer = sc.getInitParameter("Footer");

            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            String query = "select * from exam";
            ResultSet rs = st.executeQuery(query);
            ArrayList<String> courses = new ArrayList<>();
            ArrayList<String> dates = new ArrayList<>();
            ArrayList<String> times = new ArrayList<>();
            while (rs.next()) {
                courses.add(rs.getString("Course"));
                dates.add(rs.getString("Date"));
                times.add(rs.getString("Time"));
            }
            out.print(
                    "<!DOCTYPE html>"
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
                    + "<th colspan=\"6\">Examination schedule (4th Quatre, 2021-2022)</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>"
                    + "<tr>"
                    + "<tr>"
                    + "<td colspan=\"1\">" + courses.get(0) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(1) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(2) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(3) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(4) + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td colspan=\"1\"><p>" + dates.get(0) + "\n" + times.get(0) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(1) + "\n" + times.get(1) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(2) + "\n" + times.get(2) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(3) + "\n" + times.get(3) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(4) + "\n" + times.get(4) + "</p></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td colspan=\"1\">" + courses.get(5) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(6) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(7) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(8) + "</td>"
                    + "<td colspan=\"1\">" + courses.get(9) + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td colspan=\"1\"><p>" + dates.get(5) + "\n" + times.get(5) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(6) + "\n" + times.get(6) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(7) + "\n" + times.get(7) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(8) + "\n" + times.get(8) + "</p></td>"
                    + "<td colspan=\"1\"><p>" + dates.get(9) + "\n" + times.get(9) + "</p></td>"
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

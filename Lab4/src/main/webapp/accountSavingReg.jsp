<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.model.*"%>
<%@page import="com.controller.*"%>
<%@page import="com.dao.*"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment_4</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="./CSS/Style.css">

    </head>
	<body>
        <main>
            <div class="container-lg w-75 my-5 mx-auto p-5">
                <div class="border p-4 bg-success p-2 text-dark bg-opacity-10">
                    <h2>Account register</h2>
                    <form method="post" action="account-register">
                        <!-- customer_id -->
                        <div class="mb-3">
                        <%
                        Customer customer = (Customer) session.getAttribute("customer");
                        %>
                            <input type="text" class="form-control" id="customer_id" name="customer_id" hidden
                            value="<% out.println(customer.getCustomer_id()); %>"
                            >
                        </div>
                        <!-- user_id -->
                        <div class="mb-3">
                            <label for="user_id" class="form-label">User id</label>
                            <input type="text" class="form-control" id="user_id" name="user_id">
                        </div>
                        <!-- user_password -->
                        <div class="mb-3">
                            <label for="u_pwd" class="form-label">Password</label>
                            <input type="password" class="form-control" id="u_pwd" name="u_pwd">
                        </div>
                        <!-- user_name -->
                        <div class="mb-3">
                            <label for="u_name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="u_name" name="u_name">
                        </div>
                        <!-- address -->
                        <div class="mb-3">
                            <label for="u_address" class="form-label">Address</label>
                            <input type="text" class="form-control" id="u_address" name="u_address">
                        </div>
                        <!-- phone -->
                        <div class="mb-3">
                            <label for="u_phone" class="form-label">Phone</label>
                            <input type="text" class="form-control" id="u_phone" name="u_phone">
                        </div>
                        <!-- account_type -->
                        <div class="mb-3">
                            <input type="text" class="form-control" id="u_type" name="u_type" value="saving" hidden>
                        </div>
                        <!-- balance -->
                        <div class="mb-3">
                            <label for="u_balance" class="form-label">Account balance</label>
                            <input type="text" class="form-control saving" id="u_balance" name="u_balance">
                        </div>
                        <!-- rate -->
                        <div class="mb-3">
                            <label for="u_rate" class="form-label">Account rate</label>
                            <input type="text" class="form-control saving" id="u_rate" name="u_rate">
                        </div>
                        <!-- duration -->
                        <div class="mb-3">
                            <label for="u_duration" class="form-label">Duration</label>
                            <input type="text" class="form-control saving" id="u_duration" name="u_duration">
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </main>
        <script>
            (function () {

            })();
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    </body>
</html>
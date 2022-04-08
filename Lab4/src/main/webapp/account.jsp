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
        <style>
            .headLess {
                list-style-type: none;
                position: relative;
            }

            .right {
                right: 0;
                position: relative;
            }

        </style>


    </head>

    <body>
        <main>
            <div class="container-lg w-50 my-5 mx-auto p-5">
                <div class="border p-4 bg-success p-2 text-dark bg-opacity-10">
                    <% Customer customer=(Customer) session.getAttribute("customer"); %>
                        <p>Customer: <% out.println(customer.getCustomer_id()); %>
                        </p>
                        <h2>Account register</h2>
                        <form method="get" action="account-login">
                            <div class="mb-3">
                                <label class="form-label" for="u_name">account name</label>
                                <input class="form-control" type="text" id="u_name" name="u_name">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="u_pwd">password</label>
                                <input class="form-control" type="password" id="u_pwd" name="u_pwd">
                            </div>
                            <div class="mb-3 text-center">
                                <button type="submit" class="right btn btn-primary">Login</button>
                            </div>
                        </form>
                        <h2>Account create</h2>
                        <div class="d-flex flex-row justify-content-evenly"">
                        <a href=" accountSavingReg.jsp">Create new saving account</a>
                            <a href="accountCurrentReg.jsp">Create new current account</a>
                        </div>
                </div>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    </body>

</html>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.model.*"%>
<%@page import="com.controller.*"%>
<%@page import="com.dao.*"%>
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
            <div class="container-lg w-25 my-5 mx-auto p-5">
                <div class="border p-4 bg-success p-2 text-dark bg-opacity-10">
                    <h2>Customer login</h2>

                    <form method="post" action="customer-login">
                        <!-- customer id -->
                        <div class="mb-3">
                            <label for="customer_id" class="form-label">Customer id</label>
                            <input type="text" class="form-control" id="customer_id" name="customer_id">
                        </div>
                        <!-- password -->
                        <div class="mb-3">
                            <label for="customer_pwd" class="form-label">Password</label>
                            <input type="password" class="form-control" id="customer_pwd" name="customer_pwd">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    </body>

</html>

</html>

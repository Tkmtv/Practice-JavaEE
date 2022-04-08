<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.model.*"%>
<%@page import="com.controller.*"%>
<%@page import="com.dao.*"%>
<%@page import="java.text.DecimalFormat" %>
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

        </style>


    </head>

    <body>
        <main>
            <% 
                UserAccount account = (UserAccount) session.getAttribute("account");
                Customer customer= (Customer) session.getAttribute("customer"); 
            %>
                <div class="container-lg w-75 my-5 mx-auto p-5">
                    <div class="border p-4 bg-success p-2 text-dark bg-opacity-10">
                        <h3>Account information</h3>
                        <div class="row">
                            <!-- account info -->
                            <div class="col col-lg-6 border">
                                <h5>Customer information</h5>
                                <ul class="headLess">
                                    <!-- customer id -->
                                    <li class="py-2">
                                        <p>Customer: <% out.println(customer.getCustomer_id()); %>
                                    </li>
                                    <!-- user id -->
                                    <li class="py-2">
                                        <p>User id: <% out.println(account.getUser_id()); %>
                                    </li>
                                    <!-- user name -->
                                    <li class="py-2">
                                        <p>User name: <% out.println(account.getUser_name()); %>
                                    </li>
                                    <!-- address -->
                                    <li class="py-2">
                                        <p>Address: <% out.println(account.getAddress()); %>
                                    </li>
                                    <!-- phone -->
                                    <li class="py-2">
                                        <p>Phone: <% out.println(account.getPhone()); %>
                                    </li>
                                    <!-- account number -->
                                    <li class="py-2">
                                        <p>Account number: <% out.println(account.getAccount_number()); %>
                                    </li>
                                    <!-- account type -->
                                    <li class="py-2">
                                        <% 
                                        if (account.getAccount_type().equals("saving")) { 
                                            out.print("<p>Account type: Saving</p>");
                                        } else {
                                            out.print("<p>Account type: Current</p>");
                                        }
                                        %>
                                    </li>
                                    <li class="py-2">
                                        <a href="logout">Log out</a>
                                    </li>
                                </ul>

                            </div>
                            <!-- account balance -->
                            <div class="col col-lg-6 border">
                                <h5>Account balance</h5>
                                <ul class="headLess">
                                    <!-- balance -->
                                    <li class="py-2">
                                        <p>Account current balance: <% 
                                        DecimalFormat priceFormatter = new DecimalFormat("##,###,### VND");
                                        out.println(priceFormatter.format(account.getCurrentBalance())); %>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="row">
                            <!-- action -->
                            <div class="col col-lg-6 border">
                                <!-- transfer -->
                                <form method="get" action="transfer">
                                    <h5>Transfer money</h5>
                                    <div class="mb-3">
                                        <label for="receiver" class="form-label">Receiver number</label>
                                        <input type="text" class="form-control" id="receiver" name="receiver"
                                            placeholder="Receiver account number">
                                    </div>
                                    <div class="mb-3">
                                        <label for="r_type" class="form-label">Receiver account type</label>
                                        <select class="form-select" id="r_type" name="r_type">
                                            <option value="savings">Saving</option>
                                            <option value="current">Current</option>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="amount" class="form-label">Amount</label>
                                        <input type="number" class="form-control" id="amount" name="amount"
                                            placeholder="### VND">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Send</button>
                                </form>
                            </div>
                            <!-- log -->
                            <div class="col col-lg-6 border">
                                <h5>Transaction log</h5>
                                <ul class="headLess">
                                    <!-- log 1 -->
                                    <li class="py-2">
                                        <p>Transaction: <% out.println(account.getTransaction(0)); %>
                                    </li>
                                    <!-- log 2 -->
                                    <li class="py-2">
                                        <p>Transaction: <% out.println(account.getTransaction(1)); %>
                                    </li>
                                    <!-- log 3 -->
                                    <li class="py-2">
                                        <p>Transaction: <% out.println(account.getTransaction(2)); %>
                                    </li>
                                </ul>
                            </div>
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
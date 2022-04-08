<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.data.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assignment_3</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous">
<link rel="stylesheet" href="./CSS/Style.css">
</head>
<body>
    <header>
    <div class="banner" align="center">
        <h1>
            <c:out value="KFC Thu Dau Mot City"></c:out>
        </h1>
    </div>
    </header>
    <main> 
    <a href="item">Go back to main page</a> </main>
    <div class="container-lg">
        <c:set var="list" value="${combos}" scope="application" />
        <c:set var="map" value="${orders}" scope="application" />
        <c:forEach var="order" items="${orders}">
            <c:choose>
                <c:when test="${order.value > 0}">
                    <c:forEach var="combo" items="${combos}">
                        <c:choose>
                            <c:when test="${order.key eq combo.id}">
                                <div
                                    class="w-25 mx-auto my-5 h-100 border" style="background-color: white;">
                                    <h3>Item : ${combo.name}</h3>
                                    <h3>
                                        Price :
                                        <fmt:formatNumber
                                            value="${combo.calculatePrice * order.value}"
                                            pattern="##,###,### VND" />

                                    </h3>
                                </div>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>
    </div>

    </main>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.data.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
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
        <div class="container-lg">
            <form action="calculate" method="get" id="myForm">
                <div class="row">
                    <div class="col">
                        <c:set var="list" value="${combos}"
                            scope="application" />
                        <c:forEach var="combo" items="${combos}">
                            <div
                                class="container-fluid border border-dark my-3 p-3 cmb">
                                <div class="row mb-4">
                                    <div class="col col-lg-4">
                                        <h3 class="cmbName">
                                            ${combo.name}</h3>
                                    </div>
                                    <div
                                        class="col text-right d-flex flex-row-reverse align-items-center">
                                        <button type="button"
                                            class="removeBtn">Remove
                                            1</button>
                                        <button type="button"
                                            class="addBtn">Add
                                            1</button>
                                        <div class="quantity">
                                            <input class="h-100"
                                                id="lbl" type="text"
                                                value="0" disabled /> <input
                                                class="h-100"
                                                type="text" value="0"
                                                name="${combo.id}"
                                                id="val" hidden />
                                        </div>
                                        Quantity:
                                    </div>
                                </div>
                                <div class="row">
                                    <c:forEach var="item"
                                        items="${combo.items}">
                                        <div class="col col-lg-3">
                                            <div class="card">
                                                <img
                                                    src="${item.imageURL}"
                                                    class="itemImg"
                                                    alt="${item.name}">
                                                <div class="card-body">
                                                    <h5
                                                        class="card-title">${item.name}</h5>
                                                    <p
                                                        class="card-text item-cost">
                                                        <fmt:formatNumber
                                                            value="${item.price}"
                                                            pattern="##,###,### VND" />
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="row">
                                    <h4>
                                        <c:out
                                            value="${combo.discount*100}"></c:out>
                                        %
                                    </h4>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col col-lg-4" id=order>
                        <div class="container-fluid my-3">
                            <button type="submit" class="submitBtn">Buy</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </main>
    <div class="end" hidden></div>
    <script>
					(function() {
						let addBtn, removeBtn, i, parent, label, value, val;
						addBtn = document.getElementsByClassName("addBtn");
						removeBtn = document
								.getElementsByClassName("removeBtn");
						i = 0;
						for (; i < addBtn.length; i++) {
							addBtn[i].addEventListener("click", function() {
								parent = this.parentNode;
								label = parent.querySelector("#lbl");
								value = parent.querySelector("#val");
								val = parseInt(label.value);
								val++
								label.setAttribute("value", val);
								value.setAttribute("value", val);
							});

							removeBtn[i].addEventListener("click", function() {
								parent = this.parentNode;
								label = parent.querySelector("#lbl");
								value = parent.querySelector("#val");
								val = parseInt(label.value);
								if (val > 0) {
									val--
									label.setAttribute("value", val);
									value.setAttribute("value", val);
								}
							});

						}
					})();
				</script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
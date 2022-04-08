<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cse456.lab5.entities.Story"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="./CSS/Style.css">
        <link href="css/style.css" rel="stylesheet"/>

    </head>

     <body>
        <header class="p-3 mb-3 border-bottom">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 text-light text-decoration-none">
                        <span class="fs-4">Final</span>
                    </a>
                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 ms-3">
                        <li><a href="UpdateStory.jsp" class="nav-link px-2 link-light">Update story</a></li>
                        <li><a href="DeleteStory.jsp" class="nav-link px-2 link-light">Delete story</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <div class="container-lg p-3">
                <div class="border p-4 h-100">
                            <c:forEach var="st" items="${stories}">
                                <div class="card mt-3">
                                    <div class="card-body px-5">
                                        <img src="https://png.pngtree.com/png-vector/20190214/ourlarge/pngtree-vector-notes-icon-png-image_509622.jpg" class="stIcon"/>
                                        <h5 class="card-title">${st.story_title}</h5>
                                        <p class="card-text">${st.story_id}</p>
                                        <p class="card-text">${st.story_content}</p>
                                        <p class="card-text text-info">Last updated on ${st.date_of_submission}</p>
                                    </div>
                                </div>
                            </c:forEach>
                </div>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    </body>

</html>

</html>


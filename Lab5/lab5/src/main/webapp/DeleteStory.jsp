<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <li><a href="NewStory.jsp" class="nav-link px-2 link-light">New story</a></li>
                        <li><a href="OldStory.jsp" class="nav-link px-2 link-light">Old story</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <div class="container-lg p-3">
                <div class="border p-4 h-100">
                    <form method="get" action="delete">
                        <c:set var="email" value="${email}"
                                scope="application" />
                            <c:choose>
                                <c:when test="${email != null}"> 
                                    <c:choose>
                                        <c:when test="${email eq not_found}"> 
                                            <div id="emailHelp" class="form-text">You entered wrong email id or story id. Please try again</div>
                                        </c:when>
                                    </c:choose>
                                </c:when>
                            </c:choose>
                        <div class="mb-3">
                            <label for="e_id" class="form-label">Email id</label>
                            <input type="email" class="form-control" id="e_id" name="e_id">
                        </div>
                        <div class="mb-3">
                            <label for="s_id" class="form-label">Story id</label>
                            <input type="password" class="form-control" id="s_id" name="s_id">
                        </div>
                        <button type="submit" class="btn btn-primary">Go</button>
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


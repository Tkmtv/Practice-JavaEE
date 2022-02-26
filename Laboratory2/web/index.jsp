<html>
    <head>
        <title>Index</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div>
                <%
                String header = application.getInitParameter("Header");
                out.print("<h1>" + header + "</h1>");
                %>
            </div>
        </header>
        <div class="container-fluid h-100">
            <div class="row align-items-center h-100">
                <div class="col border border-2 border-info h-100">

                    <span class="underLine">
                        Latest Announcement
                    </span>

                    <a class="red" href="admitCard.jsp">
                        Download Admit Card
                    </a>
                    <a class="red" href="exam">
                        Examination routine
                    </a>
                </div>
                <div class="col border border-2 border-info h-100">
                    <div class="vert">
                        <div>
                            <form id="vision" action="vision.jsp" method="post">
                                <button class="blueBtn" type="submit" name="vision">
                                    <span>
                                        Vision
                                    </span>
                                    <span>
                                        Click here
                                    </span>
                                </button>
                            </form>
                        </div>
                        <div>
                            <form id="mission" action="mission.jsp" method="post">
                                <button class="blueBtn" type="submit" name="mission">
                                    <span>
                                        Mission
                                    </span>
                                    <span>
                                        Click here
                                    </span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col border border-2 border-info h-100">
                    <span class="fw-bold">Login</span>
                    <form id="loginForm" action="login" method="post">
                        <table>
                            <tr>
                                <td>Username</td>
                                <td><input type="text" id="uname" name="uname"/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" id="pwd" name="pwd"/></td>
                            </tr>
                        </table>
                        <button class="blueBtn" type="submit" name="go">
                            <span>
                                Go
                            </span>
                        </button>
                    </form>
                    <a class="red" href="ForgetPass.jsp">
                        Forgotten your username & password
                    </a>
                    <a class="red" href="Register.jsp">
                        Sign up
                    </a>

                </div>
            </div>
        </div>

        <footer>
            <div>
                <%
                String footer = application.getInitParameter("Footer");
                out.print("<h2>" + footer + "</h2>");
                %>
            </div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
    </body>
</html>

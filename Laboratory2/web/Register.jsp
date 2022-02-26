<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
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
        <div class="container-fluid">
            <form id="register" action="register" method="post">
                <div>Please enter the following detail</div>
                <div class="row align-items-center justify-content-start h-25 m-2 mt-5">
                    <div class="col text-start">
                        <span>Roll number*</span>

                    </div>
                    <div class="col">
                        <input type="text" id="rollnumb_r" name="rollnumb_r"/>
                    </div>
                    <div class="col">
                    </div>
                </div>
                <div class="row align-items-center justify-content-start h-25 m-2">
                    <div class="col text-start">
                        <span>Username*</span>

                    </div>
                    <div class="col text-start">
                        <input type="text" id="uname_r" name="uname_r"/>
                    </div>
                    <div class="col">
                    </div>
                </div>
                <div class="row align-items-center justify-content-start h-25 m-2">
                    <div class="col text-start">
                        <span>New password*</span>
                    </div>
                    <div class="col text-start">
                        <input type="password" id="pwd_r" name="pwd_r"/>
                    </div>
                    <div class="col">
                    </div>
                </div>
                <div class="row align-items-center justify-content-start h-25 m-2">
                    <div class="col text-start">
                        <span>Confirm password</span>
                    </div>
                    <div class="col text-start">
                        <input type="password" id="pwd_c" name="pwd_c"/>
                    </div>
                    <div class="col">
                    </div>
                </div>
                <div class="row align-items-center justify-content-start h-25 m-2">
                    <div class="col text-start">
                        <span>Email*</span>
                    </div>
                    <div class="col text-start">
                        <input type="text" id="email_r" name="email_r"/>
                    </div>
                    <div class="col">
                    </div>
                </div>
                <div class="row align-items-center justify-content-center h-25 m-2 mt-5">
                    <div class="col text-center">
                        <div class="mx-auto blk">
                            <button class="greenBtn" type="submit" name="register">
                                <span>
                                    Register
                                </span>
                        </div>
                        </button>
                    </div>
                    <div class="col text-center">
                        <div class="mx-auto blk">
                            <button class="greenBtn" type="reset" name="reset">
                                <span>
                                    Reset
                                </span>
                            </button>
                        </div>
                    </div>
                </div>

            </form>
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

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>result error</title>
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
            <div class="red">
                Please enter a valid roll number
            </div>
            <form id="result" action="result" method="post" class="h-100">
                <div class="row align-items-center h-25 m-2">
                    <div class="col h-100">
                        <span class="red">Roll number*</span>
                        <input type="text" id="rollNum" name="rollNum" placeholder="Roll number"/>
                    </div>
                    <div class="col h-100">
                        <span class="red">Quatre*</span>
                        <select name="quatre" id="quatre">
                            <option value="0" selected>Select quatre</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                    <div class="col h-100">
                        <span class="red">Year*</span>
                        <select name="year" id="year">
                            <option value="" selected>Select year</option>
                            <option value="2021-22">2021-22</option>
                        </select>
                    </div>
                </div>
                <div class="row align-items-center justify-content-center h-25 m-2">
                    <div class="col h-100">
                        <div class="mx-auto blk">
                            <button class="greenBtn" type="submit" name="search">
                                <span>
                                    Search
                                </span>
                            </button>
                        </div>
                    </div>
                    <div class="col h-100 mx-auto">
                        <div class="mx-auto blk">
                            <button class="greenBtn" type="submit" name="search">
                                <span>
                                    Search
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

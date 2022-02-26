<!DOCTYPE html>
<html>
    <head>
        <title>result success</title>
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
            <div class="row align-items-center dataContent">
                <table border="1" class="table table-bordered">				
                    <tbody>
                        <tr>
                            <td colspan=\"1\">Name</td>
                            <td colspan=\"4\">name</td>
                        </tr>
                        <tr>
                            <td colspan=\"1\">Roll</td>
                            <td colspan=\"4\">roll</td>
                        </tr>
                        <tr>
                            <td colspan=\"1\">Year</td>
                            <td colspan=\"4\">year</td>
                        </tr>
                        <tr>

                            <td colspan=\"1\">Quatre</td>
                            <td colspan=\"4\">quatre</td>
                        </tr>					
                        <tr>
                            <td colspan=\"1\">Course</td>
                            <td colspan=\"1\">course1</td>
                            <td colspan=\"1\">course2</td>
                            <td colspan=\"1\">Course3</td>
                            <td colspan=\"1\">course4</td>
                        </tr>
                        <tr>
                            <td colspan=\"1\">Grade</td>
                            <td colspan=\"1\">grade1</td>
                            <td colspan=\"1\">grade2</td>
                            <td colspan=\"1\">grade3</td>
                            <td colspan=\"1\">grade4</td>
                        </tr>				
                    </tbody>			
                </table>
            </div>
            <div class="row align-items-center">
                <form id="return" action="destroySession" method="post">
                    <button class="greenBtn" type="submit" name="return">
                        <span>
                            Back
                        </span>
                    </button>
                </form>
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

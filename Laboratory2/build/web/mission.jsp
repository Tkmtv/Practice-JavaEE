<!DOCTYPE html>

<html>
    <head>
        <title>mission</title>
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
            <p class="red">Mission</p>
            <div class="vision-content">
                <p>To create and disseminate knowledge both nationally &
                    internationally towards the transformations of the civilizations
                    into a knowledge-based society.</p>
                <p>To institutionalize the extension and field outeach
                    activities with a view to transform the university system into an
                    active instrument for social changes.</p>
            </div>
            <div>
                <form id="return" action="destroySession" method="post">
                    <div class="mx-auto blk">
                        <button class="greenBtn" type="submit" name="return">
                            <span>
                                back
                            </span>
                        </button>
                    </div>
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

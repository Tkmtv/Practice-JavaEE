<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/compound.tld" prefix="m"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Assignment_1</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
	</head>
	<body>
        <div class="container-lg h-100">
            <%
                //get value
				long finalAmount = Long.valueOf((String) request.getParameter("finalAmount"));
				long initialBalance = Long.valueOf((String) request.getParameter("initialBalance"));
				long interestRate = Long.valueOf((String) request.getParameter("interestRate"));
				long numberInterest = Long.valueOf((String) request.getParameter("numberInterest"));
				long numberPeriods = Long.valueOf((String) request.getParameter("numberPeriods"));

				pageContext.setAttribute("finalAmount", finalAmount);
				pageContext.setAttribute("initialBalance", initialBalance);
				pageContext.setAttribute("interestRate", interestRate);
				pageContext.setAttribute("numberInterest", numberInterest);
				pageContext.setAttribute("numberPeriods", numberPeriods);
                
                
			%>
                <m:compound interestRate="${interestRate}" 
                            finalAmount="${finalAmount}" 
                            numberPeriods="${numberPeriods}" 
                            numberInterest="${numberInterest}" 
                            initialBalance="${initialBalance}">
                </m:compound>
                

            
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
	</body>
</html>
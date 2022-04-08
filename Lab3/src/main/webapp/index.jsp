<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Assignment_3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
	</head>
	<body>
        <div class="container-lg h-100 mt-5">
            <form action="calculate.jsp" method="post">
                <div class="mb-3">
                    <label for="finalAmount" class="form-label">Final amount</label> 
                    <input type="text" class="form-control" required id="finalAmount" name="finalAmount"
                        placeholder="Enter final amount">
                </div>
                <div class="mb-3">
                    <label for="initialBalance" class="form-label">Initial principal balance</label> 
                    <input type="text" class="form-control" required
                        id="initialBalance" name="initialBalance"
                        placeholder="Enter initial principal balance">
                </div>
                <div class="mb-3">
                    <label for="interestRate" class="form-label">Interest rate</label> 
                    <input type="text" class="form-control" required id="interestRate" name="interestRate"
                        placeholder="Enter interest rate">
                </div>
                <div class="mb-3">
                    <label for="numberInterest" class="form-label">Number of times interest applied per time period</label> 
                    <input type="text" class="form-control"
                        required id="numberInterest" name="numberInterest"
                        placeholder="Enter number of times interest applied per time period">
                </div>
                <div class="mb-3">
                    <label for="numberPeriods" class="form-label">Number of time periods elapsed</label>
                    <input type="text" class="form-control" required
                        id="numberPeriods" name="numberPeriods"
                        placeholder="Enter number of time periods elapsed">
                </div>
                <div class="d-flex align-items-center justify-content-evenly mb-3">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-primary">Reset</button>
                </div>
            </form>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
	</body>
</html>
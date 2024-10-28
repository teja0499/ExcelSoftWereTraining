<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Customer Wise Outstanding</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />

<style>
body {
	font-family: serif;
	background-color: #f7f7f7;
}

form {
	border: solid black 1px;
	margin-top: 8%;
}

select {
	width: 40%;
}

#h5 {
	margin-top: -0.7rem;
	background-color: #f7f7f7;
	width: 6.5rem;
	height: 1%;
	font-weight: bold;
}

button {
	background-color: #4ba1dd;
	color: white;
	border: none;
	margin-top: 2.5%;
	margin-bottom: 1%;
	width: 40%;
}

.d-flex {
	display: flex;
}

.form-container {
	margin-bottom: 0.5rem;
	justify-content: space-between;
}

label {
	margin-right: 1rem;
}
</style>
</head>
<body>
	<div class="my-3 mx-3">
		<form action="details" id="formId">
			<div class="d-flex">
				<h5 style="width: 1rem"></h5>
				<h6 id="h5">Claim Printing</h6>
			</div>
			
				<div class="form-container" style="padding-left: 0.5rem">
					

					<div class="d-flex justify-content-between">
						<div style="width: 41%; margin-right: 15%">

              <div class="d-flex form-container" style="width: 41%">
                <label>Invoice Group</label> <select name="reportType"
                  id="invoice">
                  <option value="S">Summary</option>
                  <option value="D">Details</option>
                </select>
              </div>
							<div class="d-flex form-container">
								<label>Location</label> <select name="reportType" id="reportType">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

              <div class="d-flex form-container">
								<label>Stock point</label> <select name="reportType" id="stockPoint">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

							<div class="d-flex form-container">
								<label>Financial Year</label> <select name="reportType"
									id="financialYear">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

							<div class="d-flex form-container">
								<label>Claim Type</label> <select name="reportType"
									id="claim">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

							<div class="d-flex form-container">
								<label>From Claim No.</label> <select name="reportType" id="fromClaim">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

              <div class="d-flex form-container">
								<label>To Claim No</label> <select name="reportType" id="toClaim">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

              <div class="d-flex form-container">
								<label>Printing Type</label> <select name="reportType" id="print">
									<option value="S">Summary</option>
									<option value="D">Details</option>
								</select>
							</div>

             







						
						</div>
					</div>
          <div style="width: 50%; margin-right: 15%"><h1>Hi</h1></div>
					<div style="margin-left: 80%">
						<button type="submit">Submit</button>
						<button type="button">Exit</button>
					</div>
				</div>
		</form>
	</div>
	<div class="text-center">
		<span id="load"></span>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>


</body>
</html>

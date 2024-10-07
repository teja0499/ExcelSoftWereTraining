<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Summery</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<style>
	th{
	background-color:#dcdcde
	}
	</style>
</head>
<body style="background-color: #f7f7f7;">
	<div class="container">

		<h1>Summery</h1>
		<button class="btn btn-primary border-dark my-2" style="width:8%">Back</button>


		<div>
			<table class="table table-bordered border-dark">
				<thead style="border-bottom: solid black 0.15rem ;">
					<tr>
						<th colspan="6" class="text-center"  style="background-color:#dcdcde;">Details of stock transfer by the sending location</th>
						<th colspan="5" class="text-center"  style="background-color:#dcdcde;">Details of stock receipta at the  receiving location</th>
						<th colspan="2" class="text-center"  style="background-color:#dcdcde;">Form received</th>
					</tr>
					<tr class="text-center" >
						<th style="background-color:#dcdcde;">Date</th>
						<th style="background-color:#dcdcde;">Transfer No.</th>
						<th style="background-color:#dcdcde;">Sending location Details</th>
						<th style="background-color:#dcdcde;">Transporter</th>
						<th style="background-color:#dcdcde;">LR No.</th>
						<th style="background-color:#dcdcde;">LR Date</th>
						
						<th style="background-color:#dcdcde;">Date</th>
						<th style="background-color:#dcdcde;">Transfer No.</th>
						<th style="background-color:#dcdcde;">Sending location Details</th>
						<th style="background-color:#dcdcde;">Transporter</th>
						<th style="background-color:#dcdcde;">LR No.</th>
						
						<th style="background-color:#dcdcde;">Date</th>
						<th style="background-color:#dcdcde;">Transfer No.</th>
					</tr>
				</thead>
			</table>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
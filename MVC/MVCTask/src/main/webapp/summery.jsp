<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
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
</head>
<style>
p {
	margin: 0%;
	color: black;
	font-weight: bold;
}

table {
	border-collapse: collapse;
	background-color: #f7f7f7;
	font-family: serif;
}

th, td {
	border: 1px solid #000;
	text-align: center;
	padding: 8px;
}

thead th {
	position: sticky;
	top: 0;
	background-color: #dcdcde;
	z-index: 2;
	color: #14547e
}

tbody {
	max-height: 340px;
	overflow-y: auto;
	display: block;
	width: 100%;
	scrollbar-width: none;
	border-bottom: 1px solid black;
}

thead, tbody tr {
	display: table;
	width: 100%;
	table-layout: fixed;
}
</style>
<body style="background-color: #f9eceb">
	<div>
		<div class="text-center">
			<p>HEALTHCARE PVT LTD</p>
			<p>${data.locName}</p>
			<p>DISPATCH SUMMERRY REGISTER REPORT</p>
		</div>
		<div class="d-flex justify-content-between mx-3"
			style="font-family: serif">
			<p id="rdt">Report Date</p>
			<p>Finacial Year from ${data.stdt} to ${data.endt}</p>
		</div>
		<div class="mx-2 d-flex justify-content-between">
			<form action="home" method="post">
				<button id="back"
					style="background-color: #48a3da; border: none; color: white; width: 5rem; font-weight: bold; text-align: center; margin-top: 1rem">
					Back</button>
		</form>
		 <button id="excel" style="border: none" >
          <input type="hidden" id="excelLink" value="${excelLink}" />
          <img src="./img/c.png" alt="" >
        </button>
		</div>

		<div id="main" class="mx-2 my-2"
			style="height: 433px; overflow-y: auto; display: flex; justify-content: space-between;">
			<div style="width: 40%" id="leftTable">
				<table>
					<thead>
						<tr>
							<th style="width: 8rem">TRANSACTION NO</th>
							<th style="width: 5rem">DISPATCH DATE</th>
							<th style="width: 11rem">PARTY</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="division" value="" />
						<c:forEach var="data" items="${procedureData}" varStatus="status">
						
						
						<c:if test="${data.division !=  division}">
						<c:set var="division" value="${data.division}"  />
						<tr style="background-color: #faebd6"><td colspan="3" style="text-align: left;">${"Division :"} ${ data.division}</td> </tr>
						
						</c:if>
							<tr>
								<td style="width: 8rem; text-align: left">${data.dspTrnNo}
								</td>
								<td style="width: 5rem">${data.dspDt}</td>
								<td style="width: 11rem; text-align: left"><c:if
										test="${not empty data.custName}">
                        ${data.custName.length() > 24 ?
                        data.custName.substring(0, 24) : data.custName}
                      </c:if> <c:if test="${!not empty data.custName}"> N/A </c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div
				style="width: 60%; overflow-x: auto; border-right: 1px solid black"
				id="rightTable">
				<table style="width: 150rem">
					<thead>
						<tr>
							<th style="width: 15rem;">DESTINATION</th>
							<th style="width: 15rem;">TRANSPORTER</th>
							<th>GOODS VALUE</th>
							<th>INVOICE NO</th>
							<th>LR NO</th>
							<th>DRIVER NAME</th>
							<th>LORRY NUMBER</th>
							<th>LR DATE</th>
							<th>DISPATCH DELAY</th>
							<th>NO OF CASES</th>
							<th>Form No</th>
							<th>C Form Date</th>
							<th>C Form Value</th>
							<th>POD Date</th>
							<th>POD Number</th>
							<th>Reason</th>
						</tr>
					</thead>

					<tbody>
						<c:set var="division" value="" />
						<c:forEach var="data" items="${procedureData}" varStatus="status">
						<c:if test="${data.division !=  division}">
						<c:set var="division" value="${data.division}"  />
						<tr style="background-color: #faebd6 ;color: #faebd6;"><td colspan="16">T</td> </tr>
						
						</c:if>
							<tr>
								<td style="text-align: left; width: 15rem">
									${data.destination}</td>
								<td style="text-align: left; width: 15rem">
								<c:if test="${not empty data.transporter}">
        <c:if test="${data.transporter.length() <= 22}">
            ${data.transporter}
        </c:if>
        <c:if test="${data.transporter.length() > 22}">
            ${data.transporter.substring(0, 22)}...
        </c:if>
    </c:if>
									</td>
								<td style="text-align: right">${data.goodsValue}</td>
								<td style="text-align: right">${data.invNo}</td>


								<c:if test="${data.lrNum != 'HAND DELIVERY'}">
									<td style="text-align: right">${data.lrNum}</td>
								</c:if>
								<c:if test="${data.lrNum == 'HAND DELIVERY'}">
									<td style="text-align: right">H.D.</td>
								</c:if>


								<td style="text-align: right">${data.driverName}</td>
								<td style="text-align: right">${data.lorryNo}</td>
								<td>${data.lrDate}</td>
								<td style="text-align: right">${data.delayDays}</td>
								<td style="text-align: right">${data.noOfCases}</td>
								<td style="text-align: right">${data.formNum}</td>
								<td>${data.cformDate}</td>
								<td style="text-align: right">${data.cformValue}</td>
								<td>${data.podDate}</td>
								<td style="text-align: right">${data.podNum}</td>
								<td>${data.podReason}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(
				function() {
					console.log("Jquery Start");

					$("#leftTable tbody").on("scroll", function() {
						console.log("left Table");
						$("#rightTable tbody").scrollTop($(this).scrollTop());
					});

					$("#rightTable tbody").on("scroll", function() {
						console.log("Right Table");
						$("#leftTable tbody").scrollTop($(this).scrollTop());
					});
					
					
					
					$("#excel").click(function () {
					    console.log("excel");
					    const fileName = $('#excelLink').val();
					    console.log(fileName);
					    window.open(
					        "http://localhost:8080/MVCTask/ExcelFiles/" + fileName + ".xlsx",
					        "_blank"
					    );
					});

					function IST() {
						let x = new Date();
						const date = x.getDate() + '/' + x.getMonth() + '/'
								+ x.getFullYear()
						const time = new Intl.DateTimeFormat("en-IN", {
							timeZone : "Asia/Kolkata",
							hour : 'numeric',
							minute : 'numeric',
							second : 'numeric',
							hour12 : true
						}).format(new Date());
						$("#rdt").html(
								"Report Date: " + date + " Time: " + time)
					}
					IST()

				});
	</script>
</body>
</html>
</html>

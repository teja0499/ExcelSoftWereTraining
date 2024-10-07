<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style>
thead, th {
	position: sticky;
	top: 0;
	background: #abdd93;
}
</style>
</head>
<body>
	<div class="mx-2 my-2">
		<h5 class="text-center">EXCEL MEDICARE PVT. LTD.</h5>
		<h5 class="text-center">
			<s:property value="procedures[0].sendingLocation" />
		</h5>
		<h6 class="text-center text-dark">
			Stock Transfer Reconcilation Register Report From
			<s:property value="procedureData.startDate" />
			-
			<s:property value="procedureData.endDate" />
		</h6>
		<p class="d-flex justify-content-between fw-bold">
			<span id="rdt"></span> <span>Financial Year From <s:property
					value="procedureData.startDate" /> To <s:property
					value="procedureData.endDate" /></span>
		</p>
		<div class="d-flex justify-content-between my-2">
			<form action="first-page">
				<button id="back"
					style="background-color: #48a3da; border: none; color: white; width: 5rem; font-weight: bold;">
					Back</button>
			</form>

			<!-- <img src="./WEB-INF/img/download.jpg" alt=""> -->
			<button id="excel"
				style="background-color: #2d792f; border: none; color: black; width: 5rem;">Excel</button>
		</div>

		<div class=""
			style="height: 400px; overflow-y: scroll; overflow-x: scroll;">
			<table class="table-bordered border-dark"
				style="background-color: #f7f7f7; width: 125rem;">
				<thead style="border-bottom: solid black 0.15rem; position: sticky;">
					<tr style="text-align: center">
						<th colspan="6"
							style="background-color: #dcdcde; max-width: 1000px;">
							Details of stock transfer by the sending location</th>
						<th colspan="5" style="background-color: #dcdcde">Details of
							stock receipta at the receiving location</th>
						<th colspan="3" style="background-color: #dcdcde">Form
							received</th>
					</tr>
					<tr class="align-middle text-center">
						<th
							style="background-color: #dcdcde; max-width: 5rem; min-width: 5rem;">Date</th>
						<th style="background-color: #dcdcde; width: 3%">Transfer No.</th>
						<th style="background-color: #dcdcde; width: 12%">Sending
							location Details</th>
						<th style="background-color: #dcdcde; width: 10%;">Transporter</th>
						<th style="background-color: #dcdcde">LR No.</th>
						<th style="background-color: #dcdcde">LR Date</th>

						<th style="background-color: #dcdcde">Receiving location
							Details</th>
						<th style="background-color: #dcdcde">GRN Date</th>
						<th style="background-color: #dcdcde">GRN No.</th>
						<th style="background-color: #dcdcde">Max lead time</th>
						<th style="background-color: #dcdcde">Delay days</th>

						<th style="background-color: #dcdcde">Form No.</th>
						<th style="background-color: #dcdcde">Date</th>
						<th style="background-color: #dcdcde ">Amount</th>
					</tr>
				</thead>
				<tbody id="stockData" style="height: 1px">
					<s:if test="procedures != null && procedures.size() > 0">
						<s:iterator value="procedures">
							<tr>
								<td><s:property value="trfDate" /></td>
								<td><s:property value="transferNo" /></td>
								<td><s:property value="sendingLocation" /></td>
								<td><s:property value="transporter" /></td>
								<td><s:property value="lrNo" /></td>
								<td><s:property value="lrDate" /></td>
								<td><s:property value="receivingLocation" /></td>
								<td><s:property value="grnDate" /></td>
								<td><s:property value="grnNumber" /></td>
								<td><s:property value="maxLeadTime" /></td>
								<td><s:property value="delayDays" /></td>
								<td><s:property value="fFormNo" /></td>
								<td><s:property value="fFormDt" /></td>
								<td style="text-align: right;" ><s:property value="transferredValue" /></td>
							</tr>
							<tr>
								<td colspan="2"></td>
								<td>CST No: <s:property value="sendingCST" /></td>
								<td colspan="3"></td>
								<td>CST No: <s:property value="receivingCst" /></td>
								<td colspan="7"></td>
							</tr>

							<tr>
								<td colspan="2"></td>
								<td>TIN No: <s:property value="sendingTin" /></td>
								<td colspan="3"></td>
								<td>TIN No :<s:property value="receivingTin" /></td>
								<td colspan="7"></td>
							</tr>

							<tr>
								<td colspan="2"></td>
								<td>State :<s:property value="sendingState" /></td>
								<td colspan="3"></td>
								<td>State :<s:property value="receivingState" /></td>
								<td colspan="7"></td>
							</tr>
							<tr>
								<td colspan="14"><div style="min-height: 1.5rem"></div></td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						
						<tr>
								<td colspan="14">No Result available.</td>
							</tr>
					</s:else>
				</tbody>
			</table>
		</div>
		<input type="hidden" name="excelLink"
			value="<s:property value='excelLink' />" id="excelLink" />

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
	</div>
	<script>
		$(document).ready(
				function() {
					$("#rdt").html("IST()");
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
					$('#excel')
							.click(
									function() {
										console.log("excel");
										const fileName = $(excelLink).val()
										console.log(fileName);
										window.open(
												"http://localhost:8080/StrutsFinalTask/ExcelFiles/"
														+ fileName + ".xlsx",
												"_blank");

									})
				});
	</script>
</body>
</html>

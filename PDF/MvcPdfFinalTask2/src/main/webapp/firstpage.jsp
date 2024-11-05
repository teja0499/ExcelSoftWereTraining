<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

#form {
	border: solid black 1px;
	margin-top: 4%;
}

select {
	width: 50%;
}

#h5 {
	margin-top: -0.7rem;
	background-color: #f7f7f7;
	width: 7.5rem;
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

table {
	border-collapse: collapse;
	background-color: #f7f7f7;
}

th {
	border: 1px solid #000;
	text-align: center;
}

td {
	border-bottom: 1px solid black;
	border-left: 1px solid black;
	border-right: 1px solid black;
}

thead th {
	position: sticky;
	top: 0;
	background-color: #dcdcdc;
	z-index: 2;
}

tbody {
	max-height: 350px;
	overflow-y: auto;
	display: block;
	font-size: 0.9rem;
	font-family: Tahoma;
}

thead, tbody tr {
	display: table;
	width: 100%;
	table-layout: fixed;
	border: none;
}

tbody::-webkit-scrollbar {
	width: 0px;
	background: transparent;
}
</style>
</head>
<body>
	<div class="my-3 mx-3">
		<form id="formId">
			<div id="form">
				<div class="d-flex">
					<h5 style="width: 1rem"></h5>
					<h6 id="h5">Credit Note Print</h6>
				</div>

				<div style="display: flex; justify-content: space-between">
					<div class="mx-2" style="width: 40%">


						<div class="d-flex form-container">
							<label>Branch: </label> <select id="branch" name="branch">
								<option value="S">Select</option>


								<c:forEach var="branch" items="${branches}">
									<option value="${branch.locId}">${branch.locName}</option>
								</c:forEach>
							</select> </select>
						</div>

						<div class="d-flex form-container">
							<label>Stock point: </label><select name="stockPoint"
								id="stockPoint">
								<option value="S">Select</option>
							</select>
						</div>

						<div class="d-flex form-container">
							<label>Financial Year: </label> <select id="financialYear"
								name="financialYear">
								<c:forEach var="financialYear" items="${financial_years}">
									<option value="${financialYear.finYearId}">
										${financialYear.startDt.substring(0, 10)} to
										${financialYear.endDt.substring(0, 10)}</option>
								</c:forEach>
							</select>

						</div>

						<div class="d-flex form-container">
							<label>Period: </label> <select id="period" name="period">
								<c:forEach var="period" items="${periods}">
									<option value="${period.periodId}">
										${period.periodName}</option>
								</c:forEach>
							</select>



						</div>

						<div class="d-flex form-container">

							<label>Invoice Group: </label> <select id="invoice"
								name="invoice">
								<option value="1525">MAIN</option>
								<option value="471">ZENKARE</option>

							</select>
						</div>

						<div class="d-flex form-container">
							<label>Transaction Type: </label> <select id="trans" name="trans">

								<option value="12">CREDIT NOTE</option>
								<option value="13">DEBIT NOTE</option>
							</select> <input type="hidden" name="toClaimNo" id="toClaimNo_value">

						</div>

						<div class="d-flex form-container">
							<label>CN/DN type: </label> <select id="document" name="document">
								<option value="SA">Saleable</option>
								<option value="CR">Rate difference</option>
								<option value="CG">General purpose</option>
								<option value="NS">EBS Value</option>
								<option value="CT">CWD</option>

							</select>
						</div>

						<div class="d-flex form-container">
							<label>From CN/DN number: </label> <select id="fromcn"
								name="fromcn">
								<option value="S">Select</option>

							</select>
						</div>


						<div class="d-flex form-container">
							<label>To CN/DN number: </label> <select id="tocn" name="tocn">
								<option value="S">Select</option>
							</select>
						</div>

						<div class="d-flex form-container">
							<label>Language: </label> <select id="lang" name="lang">
								<option value="0">All</option>

							</select>
						</div>

						<div class="d-flex form-container">
							<label>Billing /Principle Name: </label>
							<div>
								<input class="form-check-input" type="radio" name="bpn"
									id="billingname" value="Billing Name"> <label
									class="form-check-label" for="flexRadioDefault1"
									style="margin-right: 20px;">Billing Name</label> <input
									class="form-check-input" style="margin-right: 5px;"
									type="radio" name="bpn" id="principlename"
									value="principlename"> <label class="form-check-label"
									for="flexRadioDefault2">Principle Name</label>

							</div>
							</select>
						</div>


						<div class="d-flex form-container">
							<label>Show MRP : </label>


							<div
								style="display: flex; justify-content: flex-start; width: 17rem">
								<input class="form-check-input" type="radio" name="mrp"
									id="mrpno" value="Yes"> <label class="form-check-label"
									for="" style="margin-right: 20px;">Yes</label> <input
									class="form-check-input" type="radio" name="mrp" id="mrpno"
									value="No"> <label class="form-check-label" for="">No</label>
							</div>
						</div>


						<div class="d-flex form-container">
							<label>Remark </label>
							<textarea rows="3" style="width: 17rem"></textarea>

							</select>
						</div>



					</div>
					<div class="mx-2"
						style="width: 50%; height: 400px; overflow-y: scroll;">
						<table>
							<thead>
								<tr>
									<th style="width: 3rem"></th>
									<th>Customer</th>
									<th style="width: 6rem">Invoice Date</th>
									<th style="width: 8rem">Invoice No</th>
									<th style="width: 6rem">Invoice Value</th>
								</tr>
							</thead>
							<tbody id="tableData">
								<tr class="text-center">
									<td style="width: 3rem">-</td>
									<td>-</td>
									<td style="width: 6rem">-</td>
									<td style="width: 8rem">-</td>
									<td style="width: 6rem">-</td>
								</tr>

							</tbody>
						</table>
						<span id='nodata' class='text-center'></span>
						<div class="text-center">
							<span id='na' class=" text-danger">
						</div>
						</h4>
					</div>
				</div>
			</div>

			<div style="margin-left: 80%">
				<button type="button" id="submit">Submit</button>
				<button type="button">Exit</button>
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

	<script>


$(document).ready(function () {
    console.log("Jquery Start");

    $("#branch").change(function () {
    	$('#nodata').empty()
      $("#branch option[value='S']").remove();
      $('#branch').css("background-color", "white");
	      var selectedValue = $(this).val(); 
      console.log("Selected branch ID:", selectedValue);
      $.ajax({
        url:
          "http://localhost:8080/MvcPdfFinalTask2/branch/" + $(this).val(),
        type: "GET",
        beforeSend: function () {
          console.log("Sending branch request 2");
        },
        success: function (response) {
          $("#stockPoint").empty();
          $('#stockPoint').css("background-color", "white");
          
          $.each(response, function (index, stockPoint) {
            $("#stockPoint").append(
              '<option value="' +
                stockPoint.locId +
                '">' +
                stockPoint.billingName +
                "</option>"
            );
          });
		  getTableData() 
          console.log("Sending-Stock-Point complete");
        },
        error: function (error) {
          console.log(error);
        },
      });
    });
    
    
    

    $("#financialYear").change(function () {
      $("#financialYear option[value='S']").remove();
      
	      var selectedValue = $(this).val(); 
      


      $.ajax({
        url:
          "http://localhost:8080/MvcPdfFinalTask2/period/" + $(this).val(),
        type: "GET",
        beforeSend: function () {
      
        },
        success: function (response) {
          $("#period").empty();
          $('#period').css("background-color", "white");
        
		  
          $.each(response, function (index, period) {
            $("#period").append(
              '<option value="' +
			  period.periodId +
                '">' +
                period.periodName +
                "</option>"
            );
          });
          
		  getTableData() 
        },
        error: function (error) {
          console.log(error);
        },
      });
    });
    
    $("#stockPoint").change(function () { getTableData()})
	$("#invoice").change(function () { getTableData()})
	$("#period").change(function () { getTableData()})
	$("#document").change(function () { getTableData()})
		$("#trans").change(function () { $('#nodata').empty()})

  


    	
    	function getTableData() {
    	    const stockPoint = $("#stockPoint option:selected").val(); 
			const financialYear = $("#financialYear option:selected").val(); 
			const branch = $("#branch option:selected").val(); 
			const invoice = $("#invoice option:selected").val(); 
			const period = $("#period option:selected").val(); 
			const document = $("#document option:selected").val(); 



			console.log("stockPoint ",stockPoint,",financialYear",financialYear,",branch",branch,",invoice",invoice,",period",period,",document",document) ;
			
		


    	    if(stockPoint  && stockPoint != "S" && branch!="S" )
    	  {  $.ajax({
  	        url: "http://localhost:8080/MvcPdfFinalTask2/getTable" ,
	        type: "POST",
	        data:{
	        	stockPoint :stockPoint  
	        	,financialYear:financialYear  
	        	,branch:branch  
	        	,invoice:invoice  
	        	,period:period  
	        	,document:document
	        },
	        beforeSend: function () {
				$('#tableData').empty()
				$('#nodata').empty()
				$("#tableData").append("<tr>" +
                  "<tr class='text-center'>" +
                      "<td>" +"Loading..."+
                      "</td>" +
                      "</tr>")
	            
	        },
	        success: function (response) {
	

			 if(response.length!=0)
			 {
				 $('#tableData').empty() 
				 $('#tocn').empty()
				 $('#fromcn').empty()
				 
				 $.each(response, function (index, data) {
					    $("#tableData").append(
					        "<tr>" +
					          "<td style='width: 3rem' class='text-center'>" +
					          "<input class='form-check-input' type='radio' name='table' id='" + data.cnId + "' value='" + data.cnNumber + "' data-key='"+data .rownum+"' >" +
					          "</td>" +
					          "<td>" +
					          data.custName+
					          "</td>" +
					          "<td style='width: 6rem' >" +
					          formatDate(data.cnDate) +
					          "</td>" +
					          "<td class='text-end' style='width: 8rem' >" +
					          data.cnNumber+
					          "</td>" +
					          "<td class='text-end' style='width: 6rem' >" +
					          parseFloat(data.val).toFixed(2)
					           +
					          "</td>" +
					        "</tr>"
					    );
					    $('#fromcn').append(
					    		'<option value="' +
					    		data.rownum +
					                '">' +
					                data.cnNumber +
					                "</option>"
					    )					    
					      $('#tocn').append(		
					    		'<option value="' +
					    		data.rownum +
					                '">' +
					                data.cnNumber +
					                "</option>"
					    )
					});
			 }
			 else{
				 $('#tableData').empty()
				 $('#tocn').empty()
				 $('#fromcn').empty()
				$("#tableData").append("<tr>" +
                  "<tr class='text-center'>" +
                      "<td>" +"No data found"+
                      "</td>" +
                      "</tr>")
                       $('#fromcn').append(
				    		'<option value="' +
					    		"S" +
					                '">' +
					                "Select" +
					                "</option>"
					    )
	                       $('#tocn').append(
						    		'<option value="' +
						    		"S" +
						            '">' +
						            "Select" +
						            "</option>"
						    )
			 }
	            console.log("Table complete");
	        },
	        error: function (error) {
	            console.log("Error:", error);
	        },
	    });
    	  }
		else{
			$('#stockPoint').css("background-color", "red");
		}
    	}
    
    
    $("#tableData").on("change", "input[name='table']", function() {
       
        let selectedValue = $(this).val();

        let index = $(this).data("key")-1;
        
        
        $('#fromcn').prop('selectedIndex', index);
        
        

        $('#tocn').empty();

        let response = [];
        $("#fromcn option").each(function() {
            response.push({
                value: $(this).val(),
                text: $(this).text(),
            });
           
        });

        $.each(response, function(i, option) {
            if (i >= index) { // Assuming selectedKey is a numeric index
                $("#tocn").append(
                    '<option value="' + option.value + '">' + option.text + '</option>'
                );
            }
        });
       
    });

    
    
    $("#fromcn").on("change", function() {
        let selectedKey = $(this).find("option:selected").val()-1;
        console.log("Selected Key:", selectedKey);

        $('#tocn').empty();

        let response = [];
        $("#fromcn option").each(function() {
            response.push({
                value: $(this).val(),
                text: $(this).text(),
            });
            console.log("Option Value:", $(this).val(), "Option Text:", $(this).text());
        });

        $.each(response, function(index, option) {
            if (index >= selectedKey) { // Assuming selectedKey is a numeric index
                console.log("Adding Option:", option.value, option.text);
                $("#tocn").append(
                    '<option value="' + option.value + '">' + option.text + '</option>'
                );
            }
        });
    });
    
    
    $('#submit').on('click',function(){
		const financialYear = $("#financialYear option:selected").val(); 
		const branch = $("#branch option:selected").val(); 


		const fromNum = $("#fromcn option:selected").text(); 
		const toNum = $("#tocn option:selected").text(); 
		const trns=$("#trans   option:selected").val(); 

		const document = $("#document option:selected").val(); 
		const stockPoint = $("#stockPoint option:selected").val(); 
		const period = $("#period option:selected").val(); 
			// const invoice = $("#invoice option:selected").val(); 
    	if(stockPoint  && stockPoint == "S" )
    		{
    		$('#stockPoint').css("background-color", "red");
    		}
    	if(branch=="S" )
    		{
    		$('#branch').css("background-color", "red");
    		
    		}
    	else if(toNum=="Select" || fromNum=="Select")
    		{
    		  $('#nodata').text("No data for PDF")
    		  $('#nodata').css("color", "red");
    		}
			else{
				console.log("financialYear:", financialYear);
console.log("branch:", branch);
console.log("fromNum:", fromNum);
console.log("toNum:", toNum);
console.log("trns:", trns);
console.log("document:", document);
console.log("stockPoint:", stockPoint);
console.log("period:", period);

$.ajax({
    url: "http://localhost:8080/MvcPdfFinalTask2/get-pdf",
    type: "POST",
    data: {
        finId: financialYear,
        locId: branch,
        frNum: fromNum,
        toNum: toNum,
        tranType: trns,
        invType: document,
        stockPointId: stockPoint,
        period: period
    },
    beforeSend: function () {
        console.log("Sending PDF request");
    },
    success: function (response) {
        console.log("Request successful");
        
        console.log("hi");
        console.log(response.filePath);
        const pdf=response.filePath
        if(pdf!='na')
        { window.open("http://localhost:8080/MvcPdfFinalTask2/pdf_files/"+pdf+".pdf", "_blank");}
        else
        	{
        	let x=   trns==12?'CREDIT NOTE':'DEBIT NOTE';  
        	$('#nodata').text("No data of "+x+" for PDF")
  		  $('#nodata').css("color", "red");
        	}
    },
    error: function (error) {
        console.log("Request failed");
        console.log(error);
    }
});

			}
    })
    
  //  file:///C:/Users/canncopierservicepvt/Desktop/Final%20Task/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MvcPdfFinalTask2/pdf_files/20241105_130031.pdf

    
    function formatDate(timestamp) {
        const date = new Date(timestamp);
        const day = String(date.getUTCDate()).padStart(2, "0"); // Get day and pad with leading zero
        const month = String(date.getUTCMonth() + 1).padStart(2, "0"); // Get month (0-based) and pad
        const year = date.getUTCFullYear(); // Get full year
        const dt=day+'/'+month+'/'+year;
        return dt;
      }
  
    
    
    
    
    
    
    
    
    
    
});
</script>
</body>
</html>

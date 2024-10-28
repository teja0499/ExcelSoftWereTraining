<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Customer Wise Outstanding</title>

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link
      href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
      rel="stylesheet"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />

    <style>
      body {
        font-family: serif;
        background-color: #f7f7f7;
      }

      #form {
        border: solid black 1px;
        margin-top: 8%;
      }

      select {
        width: 50%;
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

      thead,
      tbody tr {
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
      <form  id="formId">
        <div id="form">
          <div class="d-flex">
            <h5 style="width: 1rem"></h5>
            <h6 id="h5">Claim Printing</h6>
          </div>

          <div style="display: flex; justify-content: space-between">
            <div class="mx-2" style="width: 30%">
              <div class="d-flex form-container">
                <label>Invoice Group</label>
                <select id="invoice" name="invoiceGrp">
                  <option value="0">All</option>
                  <c:forEach var="invoice" items="${invoiceGrp}">
                    <option value="${invoice.paraId}">
                      ${invoice.paraDescr}
                    </option>
                  </c:forEach>
                </select>
              </div>
              <div class="d-flex form-container">
                <label>Location</label>
                <select id="location" name="location">
                  <option value="S">Select</option>
                  <option value="0">All</option>
                  <c:forEach var="location" items="${locations}">
                    <option value="${location.locId}">
                      ${location.locName}
                    </option>
                  </c:forEach>
                </select>
              </div>

              <div class="d-flex form-container">
                <label>Stock point</label>
                <select name="stockPoint" id="stockPoint">
                  <option value="S">Select</option>
                </select>
              </div>

              <div class="d-flex form-container">
                <label>Financial Year</label>
                <select id="financialYear" name="financialYear">
                  <c:forEach var="financialYear" items="${financial_years}">
                    <option value="${financialYear.finYearId}">
                      ${financialYear.startDt.substring(0, 10)} to
                      ${financialYear.endDt.substring(0, 10)}
                    </option>
                  </c:forEach>
                </select>
              </div>

              <div class="d-flex form-container">
                <label>Claim Type</label>
                <select name="claimType" id="claimType">
                  <option value="SA">Saleable</option>
                  <option value="NS">Non Saleable</option>
                </select>
              </div>

              <div class="d-flex form-container">
                <label>From Claim No.</label>
                <select  id="fromClaimNo">
                  <option value="S">Select</option>
                </select>
                <input type="hidden" name="fromClaimNo" id="fromClaimNo_value">
              </div>

              <div class="d-flex form-container">
                <label>To Claim No</label>
                <select  id="toClaimNo">
                  <option value="S">Select</option>
                </select>
                <input type="hidden" name="toClaimNo" id="toClaimNo_value">
                
              </div>

              <div class="d-flex form-container">
                <label>Printing Type</label>
                <select name="print" id="print">
                  <option value="S">Jet Print</option>
                </select>
              </div>
            </div>
            <div class="mx-2" style="width: 50%;height: 400px;overflow-y: scroll;">
              <table>
                <thead>
                  <tr>
                    <th>Customer</th>
                    <th>Invoice Name</th>
                    <th>Invoice Date</th>
                    <th>Invoice Value</th>
                  </tr>
                </thead>
                <tbody id="tableData" >
                  <tr class="text-center">
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                  </tr>
                
                </tbody>
              </table>
              <div class="text-center"><span id='na' class=" text-danger"></div></h4>
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
      crossorigin="anonymous"
    ></script>

    <script>
      $(document).ready(function () {
        console.log("Jquery Start");

        $("#location").change(function () {
          $("#location option[value='S']").remove();
          $('#location').css("background-color", "white");
   	

          var selectedValue = $(this).val(); // Get the selected value
          console.log("Selected Location ID:", selectedValue);

          console.log("location", $(this).find("option:selected").val());
          console.log($(this).val());
          $.ajax({
            url:
              "http://localhost:8080/PDF_FINAL_TASK/location/" + $(this).val(),
            type: "GET",
            beforeSend: function () {
              console.log("Sending location request 2");
            },
            success: function (response) {
              $("#stockPoint").empty();
              $('#stockPoint').css("background-color", "white");
              console.log(response.length);
              $.each(response, function (index, stockPoint) {
                $("#stockPoint").append(
                  '<option value="' +
                    stockPoint.locId +
                    '">' +
                    stockPoint.billingName +
                    "</option>"
                );
              });

              console.log("Sending-Stock-Point complete");
              getClaim();
            },
            error: function (error) {
              console.log(error);
            },
          });
        });

        $("#financialYear").change(function () {
          getClaim();
        });

        $("#invoice").change(function () {
          getClaim();
        });

        $("#stockPoint").change(function () {
          getClaim();
        });

        $("#claimType").change(function () {
          getClaim();
        });

        function getClaim() {
          
          let invGrp = $("#invoice").val();
          let loc = $("#location").val();
          let stockPoint = $("#stockPoint").val();
          let finacialyear = $("#financialYear").val();
          let claimType = $("#claimType").val();
          let index;
          console.log(
            "invGrp =",
            invGrp,
            "loc =",
            loc,
            "stockPoint =",
            stockPoint,
            "finacialyear =",
            finacialyear,
            "claimType",
            claimType
          );

          if (loc != "S" && stockPoint != "S") {
            $.ajax({
              url: "http://localhost:8080/PDF_FINAL_TASK/getClaim",
              type: "GET",
              data: {
                invoice: invGrp,
                location: loc,
                stockPoint: stockPoint,
                financialYear: finacialyear,
                claimType: claimType,
              },
              beforeSend: function () {
                console.log("Sending location request 2");
                $("#tableData").empty();
                   $("#tableData").append("<tr>" +
                  "<tr class='text-center'>" +
                      "<td>" +"Loading..."+
                      "</td>" +
                      "</tr>")
              },
              success: function (response) {
            	  
            	   $('#fromClaimNo').css("background-color", "white");
            	   $('#toClaimNo').css("background-color", "white");
                if (response.length != 0) {
                  $("#fromClaimNo").empty();
                  $("#toClaimNo").empty();
                  $("#tableData").empty();
                  $('#na').text("");



                  $.each(response, function (index, stockPoint) {
                  $("#fromClaimNo").append(
                    '<option value="' +
                      index +
                      '">' +
                      response[index][2] +
                      "</option>"
                  );

                  $("#toClaimNo").append(
                    '<option value="' +
                      index +
                      '">' +
                      response[index][2] +
                      "</option>"
                  );

                  $("#tableData").append(
                    "<tr>" +
                      "<td>" +
                      response[index][1] +
                      "</td>" +
                      "<td>" +
                      response[index][2] +
                      "</td>" +
                      "<td>" +
                      formatDate(response[index][3])
                      +
                      "</td>" +
                      "<td class='text-end'>" +
                      response[index][4] +
                      "</td>" +
                      "</tr>"
                  );
                  console.log(response[index]);
                  $('#tableData').css({'border-bottom': 'solid black 1px'  });
                });

                  
                }
                else
                {
                	$("#toClaimNo").empty();
                	$("#fromClaimNo").empty();
                	 $("#toClaimNo").append(
                             '<option value="' +
                              "NA" +
                               '">' +
                               "No Data" +
                               "</option>"
                           );
                	 
                	 
                	 $("#fromClaimNo").append(
                             '<option value="' +
                              "NA" +
                               '">' +
                               "No Data" +
                               "</option>"
                           );
                	 
                	 
                	 
                	
                  $("#tableData").empty();
                   $("#tableData").append("<tr>" +
                  "<tr class='text-center'>" +
                      "<td>" +"No data found!!!"+
                      "</td>" +
                      "</tr>")
                }




                console.log(response.length);

              
              },
              error: function (error) {
                console.log("failed");

                console.log(error);
              },
            });
          }
        }

        $("#fromClaimNo").change(function () {
          const indexFrom = parseInt($("#fromClaimNo").val());
          let response = [];
          $("#fromClaimNo option").each(function () {
            response.push({
              value: $(this).val(),
              text: $(this).text(),
            });
          });

          console.log("Response length:", response.length);
          $("#toClaimNo").empty();
          $.each(response, function (index, option) {
            if (index >= indexFrom) {
              $("#toClaimNo").append(
                '<option value="' +
                  option.value +
                  '">' +
                  option.text +
                  "</option>"
              );
            }
          });
        });

        function formatDate(timestamp) {
          const date = new Date(timestamp);
          const day = String(date.getUTCDate()).padStart(2, "0"); // Get day and pad with leading zero
          const month = String(date.getUTCMonth() + 1).padStart(2, "0"); // Get month (0-based) and pad
          const year = date.getUTCFullYear(); // Get full year
          const dt=day+'/'+month+'/'+year;
          return dt;
        }


        $('#submit').on('click',function(e){
          let loc = $("#location").val();
          let claim = $("#fromClaimNo").val();

          let fclaim = $("#fromClaimNo option:selected").text();
          let tclaim = $("#toClaimNo option:selected").text();
          
          let invoice = $("#invoice option:selected").val();
          let location = $("#location option:selected").val();
          let stockPoint = $("#stockPoint option:selected").val();
          let financialYear = $("#financialYear option:selected").val();
          let  claimType=$("#claimType option:selected").val();
         
          $('#fromClaimNo_value').val(fclaim);
          $('#toClaimNo_value').val(tclaim);
          console.log(claim)
           if(loc==='S' || claim==='S' )
        	   {
        	   $('#location').css("background-color", "red");
        	   $('#stockPoint').css("background-color", "red");
        	   $('#fromClaimNo').css("background-color", "red");
        	   $('#toClaimNo').css("background-color", "red");
        	   e.preventDefault();
        	   }
           else if(claim==='NA')
        	   {
        	   $('#na').text("No Data for PDF");
        	   e.preventDefault();
        	   }
           else{
            console.log("invoice" ,invoice);
            console.log("location",location);
            console.log("stockPoint",stockPoint);
            console.log("financialYear ",financialYear);
            console.log("claimType ",claimType);
           console.log(" fclaim ",fclaim);
           console.log("tclaim ",tclaim);
           


           $.ajax({
    url: "http://localhost:8080/PDF_FINAL_TASK/get-pdf",
    type: "POST",
    data: {
        invoiceGrp: invoice,
        location: location,
        stockPoint: stockPoint,
        financialYear: financialYear,
        claimType: claimType,
        fromClaimNo: fclaim,
        toClaimNo: tclaim
    },
    beforeSend: function () {
        console.log("Sending PDF request");
    },
    success: function (response) {
      console.log("hi");
        console.log(response.pdfLink);
        const pdf=response.pdfLink
        window.open("http://localhost:8080/PDF_FINAL_TASK/pdf_files/"+pdf+".pdf", "_blank");
    },
    error: function (error) {
        console.log("Search failed");
        console.log(error);
    }
});


     
           
           }
        })




      });
    </script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
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
  </head>
  <style>
    body {
      font-family: serif;
      background-color: #f7f7f7;
    }

    form {
      border: solid black 1px;
      z-index: 1;
    }

    select {
      width: 40%;
    }

    #h5 {
      margin-top: -0.7rem;
      z-index: 2;
      background-color: #f7f7f7;
      width: 7.7rem;
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
  </style>
  <body>
    <h1>Home</h1>
    <div class="my-3 mx-3">
      <form style="margin-top: 8%" action="summery" id="formId" method="post">
        <div class="d-flex">
          <h5 style="width: 1rem"></h5>
          <h6 id="h5">Dispatch Register</h6>
        </div>
        <div style="display: flex; padding-left: 1%">
          <div style="width: 40%; margin-right: 10%" id="left">
            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Branch</label>
              <select id="branch" name="locId">
               <option value="S">Select</option>
              <option value="0">All</option>
                <c:forEach var="branch" items="${branches}">
                  <option value="${branch.locId}">${ branch.locName}</option>
                </c:forEach>
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Division</label>
              <select id="division" name="divId">
              <option value="0">All</option>
                <c:forEach var="division" items="${divisions}">
                  <option value="${division.paraId}">
                    ${division.paraDescr}
                  </option>
                </c:forEach>
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Financial Year</label>
              <select id="financial_years" name="finYr">
              
                <c:forEach var="financialYear" items="${finYears}">
                  <option value="${financialYear.finYearId}">
                    ${financialYear.startDt.substring(0, 10)} to
                    ${financialYear.endDt.substring(0, 10)}
                  </option>
                </c:forEach>
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Start Date</label>
              <p style="width: 40%">
                <input
                  type="text"
                  id="startdate"
                  required
                  name="stdt"
                  placeholder="MM/DD/YYYY"
                  readonly
                  style="width: 100%"
                />
              </p>
            </div>
          </div>

          <div style="width: 40%">
            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Stock Point</label>
              <select name="stockPointId" id="ssp" required="required">
                <option value="0">Select</option>
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label for="reportType">Report Type</label>
              <select name="reportType" id="reportType" required="required">
                <option value="summary">Summary</option>
                <option value="details">Details</option>
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Customers</label>
              <select id="customers" name="custId">
                <option value="S">Select</option>
                
              </select>
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>End Date</label>
              <p style="width: 40%">
                <input
                  type="text"
                  id="endDate"
                  name="endt"
                  required
                  placeholder="MM/DD/YYYY"
                  style="width: 100%"
                  readonly
                />
              </p>
            </div>
            <div style="margin-left: 60%">
              <button type="submit" id="submit">Submit</button>
              <button type="button">Exit</button>
            </div>
          </div>
        </div>
      </form>
      <div class="container" id="error" style="color: red"></div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <script>
      $(document).ready(function () {
        console.log("Jquery Start");

     
        let min;
        let max;

        const fin_year = $("#financial_years").find("option:selected").text();
        const dates = fin_year.split("to");
        min = dates[0].trim();
        max = dates[1].trim();
       

        $("#startdate").val(formatDate(min));
        $("#endDate").val(formatDate(max));

        $("#startdate").datepicker({
          defaultDate: new Date(min),
          minDate: new Date(min),
          maxDate: new Date(max),
        });

        $("#endDate").datepicker({
          maxDate: new Date(max),
          minDate: new Date(min),
        });

        function formatDate(date) {
          let dateParts = date.split("-");
          const dt = dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0];
          return dt;
        }


        $("#financial_years").change(function () {
          if ($(this).val() !== "0") {
       //     $(this).find('option[value="0"]').prop("disabled", true);
         //   console.log($(this).find("option:selected").text());
            const fin_year = $(this).find("option:selected").text();
            const dates = fin_year.split("to");
            min = dates[0].trim();
            const max = dates[1].trim();
            console.log("Start Date:", min);
            console.log("End Date:", max);

            $("#endDate").datepicker("option", "minDate", new Date(min));
            $("#endDate").datepicker("option", "maxDate", new Date(max));

                //  $("#startdate").datepicker("option", "dateFormat", "yy-mm-dd");
            $("#startdate").datepicker("option", "minDate", new Date(min));
            $("#startdate").datepicker("option", "setDate", new Date(min));
            $("#startdate").datepicker("option", "defaultDate", new Date(min));

            $("#startdate").datepicker("option", "maxDate", new Date(max));

           // $("#startdate").val(min);
            //$("#endDate").val(max);
             $("#startdate").val(formatDate(min));
             $("#endDate").val(formatDate(max));
          }
        });
        
        
        
        
        /// ajax calls
        
       $('#branch').change(function () {
		console.log('branch',$(this).find("option:selected").val())
		$("#branch option[value='S']").remove();
		
    $.ajax({
              url: "http://localhost:8080/MVCTask/branchId/"+$(this).val(),
              type: "GET",
              beforeSend: function () {
                console.log("Sending location request 2");
              },
              success: function (response) {
                $("#ssp").empty();
               
                console.log(response.length);
                $.each(response, function (index, stockPoint) {
                 
                    $("#ssp").append(
                      '<option value="' +
                      stockPoint.locId +
                        '">' +
                        stockPoint.billingName +
                        "</option>"
                    );
                  });
                
                console.log("Sending-Stock-Point complete");
              },
              error: function (error) {
                console.log(error);
              },
            });

            $.ajax({
              url: "http://localhost:8080/MVCTask/Customer/"+$(this).val(),
              type: "GET",
              beforeSend: function () {
                console.log("Sending location request 2");
              },
              success: function (response) {

                $("#customers option[value='S']").remove();
               
                $("#customers").append(
                      '<option value="' +
                      0+
                        '">' +
                        "All"+
                        "</option>"
                    );
               
                console.log(response.length);
                for(let i=0;i<response.length;i++)
              {
                console.log(response[i]);
                
              }
                $.each(response, function (index, customer) {
                 
                    $("#customers").append(
                      '<option value="' +
                      customer[0]+
                        '">' +
                        customer[1] +
                        "</option>"
                    );
                  });
                
                console.log("customers complete");
              },
              error: function (error) {
                console.log(error);
              },
            });
          

	})


      });
    </script>
  </body>
</html>

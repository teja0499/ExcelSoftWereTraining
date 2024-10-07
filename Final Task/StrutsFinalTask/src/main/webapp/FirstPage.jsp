<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib uri="/struts-tags" prefix="s"%>
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
        width: 20%;
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
  </head>
  <body>
    <div class="my-3 mx-3">
      <form style="margin-top: 8%" action="summery" id="formId">
        <div class="d-flex">
          <h5 style="width: 1rem"></h5>
          <h6 id="h5">Stock Transfer Reconciliation Register</h6>
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
              <label>Sending Location</label>
              <s:select
                id="sendloc"
                name="sendinglocation"
                list="masters"
                listKey="LOC_ID"
                listValue="LOC_NAME"
                headerKey="0"
                headerValue="Select"
              />
            </div>

            <div
              style="
                justify-content: space-between;
                display: flex;
                margin-bottom: 0.5rem;
              "
            >
              <label>Receiving loction</label>
              <select name="receivingLocation" id="recloc">
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
              <select name="reportType" id="reportType">
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
              <label>Start Date</label>
              <p style="width: 40%">
                <input
                  type="text"
                  id="startdate"
                  required
                  name="startdate"
                  placeholder="MM/DD/YYYY"
                  readonly
                  style="width: 100%"
                />
              </p>
            </div>
            <div style="margin-left: 22rem">
              <input type="checkbox" id="exampleCheck1" />
              <label class="form-check-label" for="exampleCheck1"
                >Display CST/TIN Number/State</label
              >
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
              <label>Sending Stock Point</label>
              <select name="sendingStockPoint" id="ssp">
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
              <label>Receiving Stock Point</label>
              <select name="receivingStockPoint" id="rsp">
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
              <label>Financial Year</label>
              <s:select
                id="financial_years"
                name="financial_years"
                list="financial_Years"
                listKey="FIN_YEAR_ID"
                listValue="START_DT.substring(0,10) + ' to ' + END_DT.substring(0,10)"
              />
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
                  name="endDate"
                  required
                  placeholder="MM/DD/YYYY"
                  style="width: 100%"
                  readonly
                />
              </p>
            </div>
            <div style="margin-left: 60%">
              <button type="submit">Submit</button>
              <button type="button">Exit</button>
            </div>
          </div>
        </div>
      </form>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <script>
      $(document).ready(function () {
        console.log("hi");
        let min;
        let max;

        const fin_year = $("#financial_years").find("option:selected").text();
        const dates = fin_year.split("to");
        min = dates[0].trim();
        max = dates[1].trim();
        console.log(fin_year);
        $("#startdate").val(min);
        $("#endDate").val(max);

        $("#reportType").change(function () {
          console.log($(this).val());
          if ($(this).val() === "summary") {
            $("#formId").attr("action", "summary");
          } else {
            $("#formId").attr("action", "details");
          }
        });

        $("#startdate").datepicker({
          defaultDate: new Date(min),
          minDate: new Date(min),
          maxDate: new Date(max),
        });

        $("#endDate").datepicker({
          maxDate: new Date(max),
          minDate: new Date(min),
        });

        $("#startdate").change(function () {
          min = $("#startdate").val();

          $("#endDate").datepicker("option", "minDate", new Date(min));
          $("#endDate").val(max);
        });

        $("#endDate").change(function () {});

        $("#sendloc").change(function () {
          if ($(this).val() !== "0") {
            $(this).find('option[value="0"]').prop("disabled", true);

            $.ajax({
              url: "http://localhost:8080/StrutsFinalTask/receiving-location",
              data: {
                LOC_ID: $(this).val(),
              },
              type: "GET",
              beforeSend: function () {
                console.log("Sending location request 1");
              },
              success: function (response) {
                $("#recloc").empty();
                $("#recloc").append(
                  '<option value="' + 0 + '">' + "All" + "</option>"
                );
                $("#rsp").empty();
                $("#rsp").append(
                  '<option value="' + 0 + '">' + "All" + "</option>"
                );
                $.each(response.masters, function (index, location) {
                  $("#recloc").append(
                    '<option value="' +
                      location.LOC_ID +
                      '">' +
                      location.LOC_NAME +
                      "</option>"
                  );
                });
                console.log(" receiving-location complete");
              },
              error: function (error) {
                console.log(error);
              },
            });

            $.ajax({
              url: "http://localhost:8080/StrutsFinalTask/Sending-Stock-Point",
              data: {
                LOC_ID: $(this).val(),
              }, 
              type: "GET",
              beforeSend: function () {
                console.log("Sending location request 2");
              },
              success: function (response) {
                $("#ssp").empty();
                $.each(response.msts, function (index, billing) {
                  console.log("billing", billing);
                  $("#ssp").append(
                    '<option value="' +
                      billing.LOC_ID +
                      '">' +
                      billing.BILLING_NAME +
                      "</option>"
                  );
                });
                console.log("Sending-Stock-Point complete");
              },
              error: function (error) {
                console.log(error);
              },
            });
          }
        });

        $("#recloc").change(function () {
          if ($(this).val() == "0") {
            $("#rsp").empty();
            $("#rsp").append(
              '<option value="' + 0 + '">' + "All" + "</option>"
            );
          }
          if ($(this).val() !== "0") {
            $.ajax({
              url: "http://localhost:8080/StrutsFinalTask/receiving-Stock-Point",
              data: {
                LOC_ID: $(this).val(),
              },
              type: "GET",
              beforeSend: function () {
                console.log("Sending receiving request 1");
              },
              success: function (response) {
                $("#rsp").empty();
                $.each(response.msts, function (index, billing) {
                  $("#rsp").append(
                    '<option value="' +
                      billing.LOC_ID +
                      '">' +
                      billing.BILLING_NAME +
                      "</option>"
                  );
                });
                console.log("Sending-Stock-Point complete");
              },
              error: function (error) {
                console.log(error);
              },
            });
          }
        });

        $("#financial_years").change(function () {
          if ($(this).val() !== "0") {
            $(this).find('option[value="0"]').prop("disabled", true);
            console.log($(this).find("option:selected").text());
            const fin_year = $(this).find("option:selected").text();
            const dates = fin_year.split(" to ");
            min = dates[0].trim();
            const max = dates[1].trim();
            console.log("Start Date:", min);
            console.log("End Date:", max);

            $("#endDate").datepicker("option", "minDate", new Date(min));
            $("#endDate").datepicker("option", "maxDate", new Date(max));

            //      $("#startdate").datepicker("option", "dateFormat", "yy-mm-dd");
            $("#startdate").datepicker("option", "minDate", new Date(min));
            $("#startdate").datepicker("option", "setDate", new Date(min));
            $("#startdate").datepicker("option", "defaultDate", new Date(min));

            $("#startdate").datepicker("option", "maxDate", new Date(max));

            $("#startdate").val(min);
            $("#endDate").val(max);
          }
        });

        function formatDate(date) {
          const newDate = new Date();
          return newDate.toLocaleString("hi-IN");
        }
      });
    </script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib uri="/struts-tags" prefix="s"%>
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
        width: 12.12rem;
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

      .slab-input {
        width: 4rem;
      }

      .form-container {
        margin-bottom: 0.5rem;
        justify-content: space-between;
      }

      .checkbox-group {
        margin-bottom: 0.5rem;
      }

      .slabs {
        height: 1.6rem;
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
          <h6 id="h5">Customer Wise Outstanding</h6>
        </div>
        <div>
          <div class="form-container" style="padding-left: 0.5rem">
            <div class="d-flex form-container" style="width: 41%">
              <label>Financial Year</label>
              <s:select
                id="financial_years"
                name="financial_year"
                list="financial_Years"
                listKey="finYearId"
                listValue="startDt.substring(0,10) + ' to ' + endDt.substring(0,10)"
              />
            </div>

            <div class="d-flex">
              <div style="width: 41%; margin-right: 15%">
                <div class="d-flex form-container">
                  <label>Branch</label>
                  <s:select
                    id="branches"
                    name="branch"
                    list="branches"
                    listKey="locId"
                    listValue="locName"
                  headerKey="S"
                    headerValue="Select"
                  />
                </div>

                <div class="d-flex form-container">
                  <label>Division</label>
                  <s:select
                    id="divisions"
                    name="divisions"
                    list="divisions"
                    listKey="paraId"
                    listValue="paraDescr"
					headerKey="0"
                    headerValue="All"
                  />
                </div>

                <div class="d-flex form-container">
                  <label>Report Type</label>
                  <select name="reportType" id="reportType">
                    <option value="S">Summary</option>
                    <option value="D">Details</option>
                  </select>
                </div>
                
                <div class="d-flex form-container">
					<label>State</label>
					<s:select
					  id="state"
					  name="state"
					  list="states"
					  listKey="paraId"
					  listValue="paraDescr"
					  headerKey="0"
					  headerValue="All"
					/>
				  </div>
                

                <div class="checkbox-group form-check">
                  <input
                    type="checkbox"
                    class="form-check-input"
                    id="specificDateCheck"
                  />
                  <label class="form-check-label" for="specificDateCheck"
                    >Enter Specific Date</label
                  >
                </div>

             <div class="checkbox-group form-check">
  <input
    type="checkbox"
    class="form-check-input"
    id="igDiv"
    name="igDiv"
    value="N"
  />
  <label class="form-check-label" for="ignoreDivisionCheck">
    Ignore Division
  </label>
</div>

                <div class="slabs d-flex my-2" style="font-size: medium">
                  <label>Slab1:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab11"
                    id="slab11"
                    value="1"
                    readonly="readonly"
                    maxlength="3"
                  />
                  To
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab12"
                    id="slab12"
                    maxlength="3"
                    value="21"
                  />
                  <span id="slab1"></span>
                </div>

                <div class="slabs d-flex my-2">
                  <label>Slab2:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab21"
                    id="slab21"
                    maxlength="3"
                    value="22"
                    readonly="readonly"
                  />
                  To
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab22"
                    id="slab22"
                    maxlength="3"
                    value="45"
                  />
                  <span id="slab2" style="color: red"></span>
                </div>
                <div class="slabs d-flex my-2">
                  <label>Slab3:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab31"
                    id="slab31"
                    maxlength="3"
                    value="46"
                    readonly="readonly"
                  />
                  To
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab32"
                    id="slab32"
                    maxlength="3"
                    value="60"
                  />
                  <span id="slab3" style="color: red"></span>
                </div>
                <div class="slabs d-flex my-2">
                  <label>Slab4:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab41"
                    id="slab41"
                    maxlength="3"
                    value="61"
                    readonly="readonly"
                  />
                  To
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab42"
                    id="slab42"
                    maxlength="3"
                    value="180"
                  />
                  <span id="slab4" style="color: red"></span>
                </div>
                <div class="slabs d-flex my-2">
                  <label>Slab5:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab51"
                    id="slab51"
                    maxlength="3"
                    value="181"
                    readonly="readonly"
                  />
                  To
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab52"
                    id="slab52"
                    maxlength="3"
                    value="365"
                  />
                </div>
                <span id="slab5" style="color: red"></span>
                <div class="slabs d-flex my-2">
                  <label>Slab6:</label>
                  <input
                    class="mx-4 slab-input"
                    type="text"
                    name="slab61"
                    id="slab61"
                    maxlength="3"
                    value="366"
                    readonly="readonly"
                  />
                </div>
			</div>

              <div style="width: 40%">
                <div class="d-flex form-container">
                  <label>Stock Point</label>
                  <select name="stockPoint" id="stockPoint">
                    <option value="S">Select</option>
                  </select>
                </div>

                <div class="d-flex form-container">
                  <label>Party</label>
                  <select name="party" id="party">
                   <option value="S">Select</option>
                  </select>
                </div>

                <div class="d-flex form-container">
                  <label>Inv/Due Dt Wise</label>
                  <select name="invoice" id="invoice">
                    <option value="0">Due Dt Wise</option>
                    <option value="1">Inv Dt Wise</option>
                  </select>
                </div>

                <div
                  class="form-container"
                  style="display: none; display: flex"
                  id="endDateDiv"
                >
                  <label>End Date</label>
                  <input
                    type="text"
                    id="endDate"
                    name="endDate"
                    required
                    placeholder="MM/DD/YYYY"
                    readonly
                  />
                </div>
              </div>
            </div>
          </div>
          <div style="margin-left: 80%">
            <button  type="submit">Submit</button>
            <button type="button">Exit</button>
          </div>
        </div>
      </form>
    </div>
    <div class="text-center"><span id="load"></span></div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>

    <script>
      $(document).ready(function () {
        console.log("Page loaded!");
        $("#endDateDiv").hide();



		$('#financial_years').find('option').each(function() {
        var finYearId = $(this).val(); // Get the value (finYearId)
        var text = $(this).text(); // Get the display text (start and end dates)
        
        // Log the financial year ID and corresponding text to the console
       // console.log("Financial Year ID:", finYearId, " | Dates:", text);
    });


        var today = new Date();
        var dd = String(today.getDate()).padStart(2, "0");
        var mm = String(today.getMonth() + 1).padStart(2, "0");
        var yyyy = today.getFullYear();
        today =  dd + "/" + mm+"/"+yyyy;
        let slab1 =true;
        let slab2=true;
        let slab3=true;
        let slab4=true;
        let slab5=true;

        $("#endDate").datepicker({
          "dateFormat": "dd/mm/yy",
          maxDate: today
        });
        
        
        $("#igDiv").val('N');
        
        
        $('#financial_years').change(function(){
        	   const fin_year = $(this).find("option:selected").text();
               const dates = fin_year.split(" to ");
              
               const  min = dates[0].trim();
               const max = dates[1].trim();
               $("#endDate").datepicker("option", "minDate", new Date(min));
               $("#endDate").datepicker("option", "maxDate", new Date(max));
               today=formatDate(max)
               $("#endDate").val(today);
        })
        
        $(".slab-input").on("input", function () {
          let value = this.value.replace(/\D/g, "");
          value = Math.min(value, 366);
          this.value = value;
        });

        $("#slab12").on("change", function () {
          const slab21 = parseInt($("#slab12").val()) + 1;
          $("#slab21").val(slab21);

          const slab22 = parseInt($("#slab22").val());
          if (slab21 > slab22) {
        	  slab2=false
            $("#slab2").text("Start date must be less than end date");
          } else {
            $("#slab2").text("");
            slab2=true
          }
        });
        $("#slab22").on("change", function () {
          const slab21 = parseInt($("#slab12").val()) + 1;
          const slab22 = parseInt($("#slab22").val());
          const slab31 = slab22 + 1;
          const slab32 = parseInt($("#slab32").val());
          $("#slab31").val(slab31);

          if (slab21 <= slab22) {
            $("#slab2").text("");
            slab2=true
          } else {
            $("#slab2").text("Start date must be less than end date");
            slab2=false
          }
          if (slab31 > slab32) {
            $("#slab3").text("Start date must be less than end date");
            slab3=false
          }
        });

        $("#slab32").on("change", function () {
          const slab31 = parseInt($("#slab22").val()) + 1;
          const slab32 = parseInt($("#slab32").val());
          const slab41 = slab32 + 1;
          const slab42 = parseInt($("#slab42").val());
          $("#slab41").val(slab41);

          if (slab31 <= slab32) {
            $("#slab3").text("");
            slab3=true
          } else {
            $("#slab3").text("Start date must be less than end date");
            slab3=false
          }
          if (slab41 > slab42) {
        	  slab4=false
            $("#slab4").text("Start date must be less than end date");
          }
        });

        $("#slab42").on("change", function () {
          const slab41 = parseInt($("#slab32").val()) + 1;
          const slab42 = parseInt($("#slab42").val());
          const slab51 = slab42 + 1;
          const slab52 = parseInt($("#slab52").val());
          $("#slab51").val(slab51);

          if (slab41 <= slab42) {
        	  slab4=true
            $("#slab4").text("");
          } else {
        	  slab4=false
            $("#slab4").text("Start date must be less than end date");
          }
          if (slab51 > slab52) {
        	  slab5=false
            $("#slab5").text("Start date must be less than end date");
          }
        });

        $("#slab52").on("change", function () {
          const slab51 = parseInt($("#slab42").val()) + 1;
          const slab52 = parseInt($("#slab52").val());
          //  const slab61=slab52+1;
          //  const slab52=parseInt($('#slab52').val());
          // $('#slab61').val(slab61);

          if (slab51 <= slab52) {
            $("#slab5").text("");
            slab5=true
          } else {
        	  slab5=false
            $("#slab5").text("Start date must be less than end date");
          }
        });

        $("#branches").change(function () {
          console.log($(this).val());
          $("#branches").css("background-color", "white");

          $(this).find('option[value="S"]').prop("disabled", true);

          $.ajax({
            url: "http://localhost:8080/StrutsFinalTask2/get-StockPoint",
            data: { LOC_ID: $(this).val() },
            beforeSend: function () {
              $("#load").text("Loading...");
            },
            success: function (response) {
              $("#stockPoint").empty();
              $("#stockPoint").css("background-color", "white");

              $("#load").text("");
              
              $("#stockPoint").append(
                      '<option value="' +
                       0 +
                        '">' +
                        "All" +
                        "</option>"
                    );

              $.each(response.stockpoint_list, function (index, stockpoint) {
                $("#stockPoint").append(
                  '<option value="' +
                    stockpoint.locId +
                    '">' +
                    stockpoint.billingName +
                    "</option>"
                );
              });
            },
            error: function (error) {
              console.log(error);
            },
          });

          $.ajax({
            url: "http://localhost:8080/StrutsFinalTask2/get-party",
            data: { locId: $(this).val() },
            beforeSend: function () {
              $("#load").text("Loading...");
            },
            success: function (response) {
              $("#party").empty();
              $("#party").css("background-color", "white");
              $("#load").text("");
              
              $("#party").append(
                      '<option value="' +
    				  0 +
                        '">' +
                        "All" +
                        "</option>"
                    );

              $.each(response.customerList, function (index, customer) {
		
                $("#party").append(
                  '<option value="' +
				  customer.custId +
                    '">' +
                    customer.custName +
                    "</option>"
                );
              });
            },
            error: function (error) {
              console.log(error);
            },
          });
        });
        
        
        $('#state').change(function (){
        	 $("#state").css("background-color", "white");
        })
        
        
         const ignoreDivisionCheck = document.getElementById('ignoreDivisionCheck');


        function getCheckboxValue() {
            return $('#ignoreDivisionCheck').is(':checked') ? 'Y' : 'N';
          }

 
        $('#ignoreDivisionCheck').change(function() {
            console.log(getCheckboxValue()); // Outputs 'Y' if checked, 'N' if unchecked
          });
        
        
        function formatDate(date) {
        	let dateParts = date.split("-");     	
       	 const dt=dateParts[2]+"/"+dateParts[1]+"/"+dateParts[0];
           console.log(dt);
        	 return dt;
//return date;
        }
        
        $("#specificDateCheck").on("change", function () {
            if ($(this).is(":checked")) {
              $("#endDate").val(today);
              console.log("show");

              $("#endDateDiv").show();
            } else {
              console.log("hide");

              $("#endDateDiv").hide();
            }
          });
        
        
        
        $("#igDiv").on("change", function () {
        	if ($(this).is(":checked")) {
                $("#igDiv").val('Y');
              } else {
            	  $("#igDiv").val('N');
              }
              console.log( $("#igDiv").val());
              
        })
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        $('#formId').on('submit',function (e){
        	console.log("ssssssssssss")
        	 const stockPoint=$('#stockPoint').val();
      	 const party=$('#party').val();
     	  let isValid=true;
         // console.log(branches)
       	  if(branches== 0)
       		  {
       	  $("#branches").css("background-color", "red");
       		  $("#party").css("background-color", "red");
       		$("#stockPoint").css("background-color", "red");
       		
       		isValid=false;
       		  }
         if($('#stockPoint').val==='S' && !isValid){
        	 $("#stockPoint").css("background-color", "red");
        	 isValid=false;
         }
         if($('#party').val==='S' && !isValid){
        	 $("#party").css("background-color", "red");
        	 isValid=false;
         }
         console.log($('#endDate').val())
       	console.log("ffffffffffff",isValid ,slab4 ,slab5 ,slab3 ,slab2 , slab1)
       	  if(!isValid || !slab4 ||!slab5 ||!slab3 ||!slab2 || !slab1){
       		  e.preventDefault();
       	  }
       	
       	
        })
      });
    </script>
  </body>
</html>

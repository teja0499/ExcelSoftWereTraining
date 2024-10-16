<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib uri="/struts-tags" prefix="s"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        width: 100%;
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
  <body style="background-color:#f8eefa ">
    <div class="mx-1 my-2 border border-dark">
      <div class="text-center mx-2" style="color:#000408 ; font-weight: bolder;" >
        <h5  style="color:#000408 ; font-weight: bold;" >HEALTHCARE PVT LTD</h5>
        <h5  style="color:#000408 ; font-weight: bold;" ><s:property value="procedures.get(0).getLocName()"/> </h5>
        <h5 style="color:#000408 ; font-weight: bold;" >Customer Wise Outstanding (Specific Date)Report From 01/01/2024</h5>
        <div>
          <h5 style="text-align: left;color: black; font-family: serif;"><span id="rdt"> </span></h5>
        </div>
      </div>
      <div class="d-flex justify-content-between mx-2 " >
        <form action="home">
          <button
            id="back"
            style="
              background-color: #48a3da;
              border: none;
              color: white;
              width: 5rem;
              font-weight: bold;
              text-align: center;
              margin-top: 1rem
            "
          >
            Back
          </button>
        </form>

        <!-- <img src="./WEB-INF/img/download.jpg" alt=""> -->
        <button id="excel" style="border: none">
          <img src="./img/c.png" alt="" />
        </button>
      </div>
      <div
        id="main"
        style="
          width: 99%;
          display: flex;
          justify-content: space-between;
          max-height: 450px;
          overflow-y: auto;
          scrollbar-width: none;
         
           class="mx-2"
      >
        <div class="" id="leftTable" style="scrollbar-width: none; font-family: serif;">
          <table class="" style="width: 75rem; border-bottom: 1px solid black">
            <thead style="color: #3b5973">
              <th style="width: 5rem">Customer Code</th>
              <th>HQ</th>
              <th>State</th>
              <th>Customer</th>
              <th>Invoice No.</th>
              <th>Invoice Amt</th>
              <th>Tran Date</th>
              <th>Due Date</th>
            </thead>
            <tbody id="stockData"  style="font-family: serif;">
             <c:set var="custCode" value="" />
              <c:forEach
                var="procedure"
                items="${procedures}"
                varStatus="status"
              >
              <c:if test="${procedure.custCd != custCode}">
              <tr style="">
                    <td style="width: 5rem">${procedure.custCd}</td>
                    <td>${procedure.hq}</td>
                    <td>${procedure.state}</td>
                    <td colspan="2">${procedure.custName}</td>
                    <td>${procedure.destination}</td>
                    <td colspan="2">
                      CREDIT LIMIT : ${procedure.totCreditLmt}
                    </td>
                  </tr>
                   <c:set var="custCode" value="${procedure.custCd}"  />
              </c:if>
              
              
              <tr>
                  <td style="width: 5rem"></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>${procedure.invoiceNo}</td>
                  <td style="text-align: right;">${procedure.adjAmount}</td>
                  <td>${procedure.tranDate}</td>
                  <td>${procedure.dueDate}</td>
                </tr>
                
                <c:if
                  test="${procedures.size() == status.index+1 || procedures[status.index +1].custCd != custCode}"
                >
                  <td colspan="8">Customer Total :</td>
                 
                  
                </c:if>
                
                
                </c:forEach>
            </tbody>
          </table>
        </div>

        <div
          id="rightTable"
          style="
            overflow-x: auto;
            border-left: 1px solid black;
            border-right: 1px solid black"
            
        >
          <table style="width: 120rem; border-bottom: 1px solid black ;font-family: serif;" class="">
            <thead style="color: #3b5973">
              <tr style="">
                <th>Receivable but not due</th>
                <th>
                  <s:property value="data.slab11" />-<s:property
                    value="data.slab12"
                  />
                </th>
                <th>
                  <s:property value="data.slab21" />-<s:property
                    value="data.slab22"
                  />
                </th>
                <th>
                  <s:property value="data.slab31" />-<s:property
                    value="data.slab32"
                  />
                </th>
                <th>
                  <s:property value="data.slab41" />-<s:property
                    value="data.slab42"
                  />
                </th>
                <th>
                  <s:property value="data.slab51" />-<s:property
                    value="data.slab52"
                  />
                </th>
                <th>>366</th>
                <th>Unadjusted Credit Note</th>
                <th>Advance</th>
                <th>Net Outstanding</th>
                <th>Remark</th>
                <th>Receivable Remark</th>
                <th>LR Date</th>
                <th>LR Number</th>
              </tr>
            </thead>
            <tbody style="text-align: right; font-family: serif;">
              <c:set var="nreceivable" value="${0}" />
              <c:set var="nslab1" value="${0}" />
              <c:set var="nslab2" value="${0}" />
              <c:set var="nslab3" value="${0}" />
              <c:set var="nslab4" value="${0}" />
              <c:set var="nslab5" value="${0}" />
              <c:set var="nslab6" value="${0}" />
              <c:set var="nucn" value="${0}" />
              <c:set var="nadv" value="${0}" />
               <c:set var="custCode" value="" />
              <c:forEach
                var="procedure"
                items="${procedures}"
                varStatus="status"
              >
              <c:if test="${procedure.custCd != custCode}">
                  <tr> <td colspan="14" style="color: #f7f7f7">T</td></tr>
                   <c:set var="custCode" value="${procedure.custCd}"  />
                </c:if>
                <tr>
                  <td>${procedure.receivable}</td>
                  <td>${procedure.slab1}</td>
                  <td>${procedure.slab2}</td>
                  <td>${procedure.slab3}</td>
                  <td>${procedure.slab4}</td>
                  <td>${procedure.slab5}</td>
                  <td>${procedure.slab6}</td>
                  <td>${procedure.unadjCr}</td>
                  <td>${procedure.advance}</td>
                  <td>
                    ${ procedure.receivable + procedure.slab1
                    + procedure.slab2 + procedure.slab3 + procedure.slab4 +
                    procedure.slab5 + procedure.slab6 +procedure.advance }
                  </td>
                  <td>${procedure.remark}</td>
                  <td>${procedure.receivableRemark}</td>
                  <td>${procedure.lrDate}</td>
                  <td style="text-align: left;">${procedure.lrNumber}</td>
                </tr>

                <c:set var="nreceivable" value="${nreceivable+procedure.receivable}"/>
                <c:set var="nslab1" value="${nslab1+procedure.slab1}" />
              <c:set var="nslab2" value="${nslab2+procedure.slab2}" />
              <c:set var="nslab3" value="${nslab3+procedure.slab3}" />
              <c:set var="nslab4" value="${nslab4+procedure.slab4}" />
              <c:set var="nslab5" value="${nslab5+procedure.slab5}" />
              <c:set var="nslab6" value="${nslab6+procedure.slab6}" />
              <c:set var="nucn" value="${ nucn+  procedure.unadjCr}" />
              <c:set var="nadv" value="${nadv +procedure.advance}" />
              
              
              
                <c:if
                  test="${procedures.size() == status.index+1 || procedures[status.index +1].custCd != custCode}"
                >
                <tr style="text-align: right;">
                  <td>${nreceivable}</td>
                  <td>${nslab1}</td>
                  <td>${nslab2}</td>
                  <td>${nslab3}</td>
                  <td>${nslab4}</td>
                  <td>${nslab5}</td>
                  <td>${nslab6}</td>
                  <td>${nucn}</td>
                  <td>${nadv}</td>
                  <td>
                    ${nslab1 + nslab2 + nslab3 + nslab4 + nslab5 + nslab6  + adv}
                  </td>

                  <td colspan="4" style="color: black">  ${procedures[status.index +1].custCd != null ? procedures[status.index +1].custCd:""}</td>
                  </tr>
                  
                   <c:set var="nreceivable" value="${0}" />
              <c:set var="nslab1" value="${0}" />
              <c:set var="nslab2" value="${0}" />
              <c:set var="nslab3" value="${0}" />
              <c:set var="nslab4" value="${0}" />
              <c:set var="nslab5" value="${0}" />
              <c:set var="nslab6" value="${0}" />
              <c:set var="nucn" value="${0}" />
              <c:set var="nadv" value="${0}" />
                  <c:set var="custCd" value="${procedure.custCd}" />
                </c:if>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
        <form action="home" style="display: flex;justify-content: flex-end;" class="mx-2 my-2">
          <button
            id="back"
            style="
              background-color: #48a3da;
              border: none;
              color: white;
              width: 5rem;
              font-weight: bold;
            "
          >
            Exit
          </button>
        </form>
    </div>
<input type="hidden" name="excelLink"
			value="<s:property value='excelLink' />" id="excelLink" />

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <script>
      $(document).ready(function () {
        console.log("Jqury start");

        $("#leftTable tbody").on("scroll", function () {
          console.log("left Table");
          $("#rightTable tbody").scrollTop($(this).scrollTop());
        });

        $("#rightTable tbody").on("scroll", function () {
          console.log("Right Table");
          $("#leftTable tbody").scrollTop($(this).scrollTop());
        });
        $("#excel").click(function () {
          console.log("excel");
          const fileName = $(excelLink).val();
          console.log(fileName);
          window.open(
            "http://localhost:8080/StrutsFinalTask2/ExcelFiles/" +
              fileName +
              ".xlsx",
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

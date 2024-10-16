<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
    <div class="text-center mx-2 my-2">
      <h3>HEALTHCARE PVT LTD</h3>
      <h3>All Location</h3>
      <h3>Customer Wise Outstanding (Specific Date)Report From 01/01/2024</h3>
      <div>
        <h5>Report Date</h5>
      </div>
      <div
        id="main"
        style="width: 100%; display: flex; justify-content: space-between; max-height: 450px;
            overflow-y: auto;scrollbar-width: none;"
      >
        <div
          class="mx-2"
          id="leftTable"
          style=" scrollbar-width: none;;
           
          "
        >
          <table class="" style=" width: 50rem;border-bottom: 1px solid black">
            <thead>
              <th>Customer Code</th>
              <th>HQ</th>
              <th>State</th>
              <th>Customer</th>
              <th>Invoice No.</th>
              <th>Invoice Amt</th>
              <th>Tran Date</th>
              <th>Due Date</th>
            </thead>
            <tbody id="stockData">
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
            </tbody>
          </table>
        </div>

        <div id="rightTable" style="overflow-x: auto;border-left:1px solid black;border-right:1px solid black ">
          <table style="width: 120rem;border-bottom: 1px solid black" class="">
            <thead>
              <tr style="">
                <th>Receivable but not due</th>
                <th>1-21</th>
                <th>22-45</th>
                <th>46-60</th>
                <th>61-90</th>
                <th>91-180</th>
                <th>181-365</th>
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
            <tbody>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
               <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              

              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
              <tr>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
                <td>Tejas</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    
     <s:iterator value="procedures" status="index">
              
                <s:if test="%{#custCd != custCd}">
                  <td colspan="14" style="color: #f7f7f7">T</td>
                </s:if>
                <tr>
                  <td><s:property value="receivable" /></td>
                  <td><s:property value="slab1" /></td>
                  <td><s:property value="slab2" /></td>
                  <td><s:property value="slab3" /></td>
                  <td><s:property value="slab4" /></td>
                  <td><s:property value="slab5" /></td>
                  <td><s:property value="slab6" /></td>
                  <td><s:property value="unadjCr" /></td>
                  <td><s:property value="advance" /></td>
                  <td>
                    <s:property
                      value="%{slab1 + slab2 +slab3 + slab4 + slab5 + slab6 +advance}"
                    />
                  </td>
                  <td><s:property value="remark" /></td>
                  <td><s:property value="receivableRemark" /></td>
                  <td><s:property value="lrDate" /></td>
                  <td><s:property value="lrNumber" /></td>
                </tr>
                 
                  <s:set var="nslab1" value="%{#nslab1 + procedure.slab1}" />
                    <s:set var="nslab2" value="%{#nslab2 + procedure.slab2}" />
                    <s:set var="nslab3" value="%{#nslab3 + procedure.slab3}" />
                    <s:set var="nslab4" value="%{#nslab4 + procedure.slab4}" />
                    <s:set var="nslab5" value="%{#nslab5 + procedure.slab5}" />
                    <s:set var="nslab6" value="%{#nslab6 + procedure.slab6}" />

                <s:if test="%{#custCd != custCd || procedures.size()==index+1}">
                <tr>
                <td><c:out value="${nreceivable}"/>  s</td>
                 <td><s:property value="%{#nslab1}" />s</td>
                 
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td colspan="4"></td>
                  </tr>
                  
                  <s:set var="nslab1" value="n" />
                  <s:set var="nslab2" value="n" />
                  <s:set var="nslab3" value="n" />
                  <s:set var="nslab4" value="n" />
                  <s:set var="nslab5" value="n" />
                  <s:set var="nslab6" value="n" />
                  <s:set var="nucn" value="n" />
                  <s:set var="nadv" value="n" />
                 
                </s:if>
                
              </s:iterator>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <script>
      $(document).ready(function () {
        console.log("Jqury start");
        
        $('#leftTable tbody').on('scroll', function () {
        	 console.log("left Table");
            $('#rightTable tbody').scrollTop($(this).scrollTop());
        });

        $('#rightTable tbody').on('scroll', function () {
        	  console.log("Right Table");
            $('#leftTable tbody').scrollTop($(this).scrollTop());
        });

        
        
     
      });
    </script>
  </body>
</html>

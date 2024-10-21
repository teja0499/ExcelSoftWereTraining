<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> <table>
            <thead>
              <th>DESTINATION</th>
              <th>TRANSPORTER</th>
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
            </thead>
            <tbody>
                <c:forEach var="i" begin="1" end="100">
                <tr>
                  <td >${i}</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  <td >${i}</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  <td >${i}</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  <td >${i}</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  <td >${i}</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  <td >Tejas</td>
                  
                </tr>
              </c:forEach>
            </tbody>
          </table>
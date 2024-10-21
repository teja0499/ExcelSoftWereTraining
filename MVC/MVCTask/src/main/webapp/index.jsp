<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hii</h1>
<form   action="${pageContext.request.contextPath}/home" method="post">
<button type="submit">Submit</button>
</form>

<form  action="home"  method="post">
<button type="submit">Submit</button>
</form>
</body>
</html>
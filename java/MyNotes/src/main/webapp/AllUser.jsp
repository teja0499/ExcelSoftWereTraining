<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Dynamic User Table</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 8px;
	text-align: left;
}

 thead, th {
      position: sticky;
      top: 0;
      background: #ABDD93;
    }
  thead th {
    position: sticky;
    top: 0;
    background: #ABDD93;
    z-index: 10;
}
.fixTableHead {
    overflow-y: auto;
    max-height: 400px; 
}

</style>
</head>
<body>

	<h2>User Information Table</h2>

	<%
	String url = "jdbc:mysql://localhost:3306/user";
	String user = "root";
	String pass = "root";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pass);

		String query = "SELECT * FROM user_data";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();

		
	%>
	<div class="fixTableHead">
	<table class=" container">
		<thead >
			<tr>
				<th>Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Qualification</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			
			while (rs.next()) {
			%>
			<tr >
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("mobile")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("qualification")%></td>
				<td><%=rs.getString("dob")%></td>
				<td><%=rs.getString("gender")%></td>
				<td>
					<form action="editUser" method="get" style="display: inline;">
						<input type="hidden" name="id" value="<%=rs.getInt("id")%>">
						<input type="submit" value="Edit" class="btn btn-primary">
					</form>
					<form action="deleteUser" method="post" style="display: inline;">
						<input type="hidden" name="id" value="<%=rs.getInt("id")%>">
						<input type="submit" value="Delete" class="btn btn-danger">
					</form>
				</td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table >
</div>
	<%
	} catch (Exception e) {
	out.println("<p>Error: " + e.getMessage() + "</p>");
	e.printStackTrace();
	} finally {
	if (rs != null)
		rs.close();
	if (ps != null)
		ps.close();
	if (conn != null)
		conn.close();
	}
	%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
</head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />

<body>
	<div class="container">
		<form action="updateUser" method="post"
			class="row g-3 needs-validation">
			<div class="col-md-6">
				<label for="Name" class="form-label">Name</label> <input type="text"
					class="form-control" id="Name"
					value="<s:property value='%{name}' />" required name="name" />
				<div style="color: red;" id="invalid-Name"></div>
			</div>

			<div class="col-md-6">
				<label for="Email" class="form-label">Email</label> <input
					type="email" value="<s:property value='%{email}' />"
					class="form-control" id="Email" name="email" required />
				<div style="color: red;" id="invalid-email"></div>
			</div>

			<div class="col-md-6">
				<label for="mobile" class="form-label">Mobile Number</label> <input
					type="tel" class="form-control" id="mobile" name="mobile"
					value="<s:property value='%{mobile}' />" maxlength=10 minlength=10
					required />
				<div style="color: red;" id="invalid-mobile"></div>
			</div>

			<div class="col-md-6">
				<label for="dob" class="form-label">Date of Birth</label> <input
					type="text" id="datepicker-1" name="dob"
					value="<s:property value='%{dob}' />" required
					placeholder="MM/DD/YYYY" readonly />
				<div style="color: red;" id="invalid-datepicker-1"></div>
			</div>

			<div class="col-md-6">
				<label for="Qualification" class="form-label">Qualification</label>
				<select class="form-select" id="Qualification" name="qualification"
					required>

					<option value="SSC"
						<s:if test="%{qualification == 'SSC'}">selected</s:if>>SSC</option>
					<option value="HSC"
						<s:if test="%{qualification == 'HSC'}">selected</s:if>>HSC</option>
					<option value="Graduation"
						<s:if test="%{qualification == 'Graduation'}">selected</s:if>>Graduation</option>
					<option value="BE"
						<s:if test="%{qualification == 'BE'}">selected</s:if>>BE</option>
				</select>
				<div style="color: red;" id="invalid-option"></div>
			</div>
			<input type="hidden" name="id" value="<s:property value='id' />" />
			<div class="col-md-6" id="flexRadio">
				<label for="gender" class="form-label" style="margin-right: 25px;">Gender</label>
				<div>
					<input class="form-check-input" style="margin-right: 5px;"
						type="radio" name="gender" id="flexRadioDefault1" value="male"
						<s:if test="%{gender == 'male'}">checked</s:if> /> <label
						class="form-check-label" for="flexRadioDefault1"
						style="margin-right: 20px;">Male</label> <input
						class="form-check-input" style="margin-right: 5px;" type="radio"
						name="gender" id="flexRadioDefault2" value="female"
						<s:if test="%{gender == 'female'}">checked</s:if> /> <label
						class="form-check-label" for="flexRadioDefault2">Female</label>
				</div>
				<div style="color: red;" id="invalid-gender"></div>
			</div>
			
			  <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" required  name="password" value="<s:property value='%{password}' />"  />
          <div style="color: red;"  id="invalid-password"></div>
        </div>
			<div class="col-12 d-flex justify-content-between">
				<input type="submit" value="Submit" class="btn btn-primary"
					id="submit" />
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			// Retrieve the value of the `name` property from JSP
			var name = "<s:property value='%{name}' />";
			var dob = "<s:property value='%{dob}' />";

			// Log the name to the console
			console.log("name:", name);

			// Initialize the datepicker with the dob value
			$('#datepicker-1').datepicker({
				dateFormat : "mm/dd/yy",
				defaultDate : dob, // Set the default date to the `dob` value from JSP
				maxDate : new Date()
			// Set the maximum date to today
			});
		});
	</script>
</body>
</html>

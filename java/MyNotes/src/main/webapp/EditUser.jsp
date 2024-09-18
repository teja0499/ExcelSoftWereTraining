<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Edit User</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h2>Edit User</h2>

    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="${id}">

        <div class="col-md-6">
            <label for="Name" class="form-label">Name</label> 
            <input type="text" class="form-control" id="Name" value="${name}" required name="name" />
            <div style="color: red;" id="invalid-Name"></div>
        </div>

        <div class="col-md-6">
            <label for="Email" class="form-label">Email</label> 
            <input type="email" class="form-control" id="Email" value="${email}" name="email" required />
            <div style="color: red;" id="invalid-email"></div>
        </div>

        <div class="col-md-6">
            <label for="mobile" class="form-label">Mobile Number</label> 
            <input type="tel" class="form-control" id="mobile" name="mobile" value="${mobile}" maxlength=10 minlength=10 required />
            <div style="color: red;" id="invalid-mobile"></div>
        </div>

        <div class="col-md-6">
            <label for="datepicker" class="form-label">Date of Birth</label>
            <input type="text" class="form-control" id="datepicker" name="dob" value="${dob}" required placeholder="MM/DD/YYYY">
            <div style="color: red;" id="invalid-datepicker"></div>
        </div>

        <div class="col-md-6">
            <label for="Qualification" class="form-label">Qualification</label> 
            <select class="form-select" id="Qualification" name="Qualification" required>
                <option value="SSC" ${qualification == 'SSC' ? 'selected' : ''}>SSC</option>
                <option value="HSC" ${qualification == 'HSC' ? 'selected' : ''}>HSC</option>
                <option value="Graduation" ${qualification == 'Graduation' ? 'selected' : ''}>Graduation</option>
                <option value="BE" ${qualification == 'BE' ? 'selected' : ''}>BE</option>
            </select>
            <div style="color: red;" id="invalid-option"></div>
        </div>

        <div class="col-md-6">
            <label class="form-label" style="margin-right: 25px;">Gender</label>
            <div>
                <input class="form-check-input" style="margin-right: 5px;" type="radio" name="gender" id="flexRadioDefault1" ${gender == 'male' ? 'checked' : ''} value="male">
                <label class="form-check-label" for="flexRadioDefault1" style="margin-right: 20px;">Male</label>
            
                <input class="form-check-input" style="margin-right: 5px;" type="radio" name="gender" id="flexRadioDefault2" value="female" ${gender == 'female' ? 'checked' : ''}>
                <label class="form-check-label" for="flexRadioDefault2">Female</label>
                
                <div style="color: red;" id="invalid-gender"></div>
            </div>
        </div>

        <input type="submit" value="Update" class="btn btn-primary my-2">
    </form>

    <form action="back">
        <input type="submit" value="Back" class="btn btn-primary my-2">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
    	console.log("hiiiiiii", "${dob}" )
        $('#datepicker').datepicker({
            dateFormat: "mm/dd/yy",
            defaultDate: "${dob}"  ,
            maxDate: new Date()
        });
    });
</script>
</body>
</html>

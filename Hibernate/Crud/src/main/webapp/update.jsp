<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous" />
</head>

<body>
    <div class="container">
        <s:form action="updateUser" method="post" class="row g-3 needs-validation" id="userForm">

        <div class="col-md-6">
            <!-- <label for="Name" class="form-label">Name</label> -->
            <s:hidden id="id" key="user.id" cssClass="form-control"  />
            <div style="color: red;" id="invalid-Name"></div>
        </div>

            <div class="col-md-6">
                <!-- <label for="Name" class="form-label">Name</label> -->
                <s:textfield id="Name" placeholder="Enter Name" label="Name" key="user.name" cssClass="form-control" requiredLabel="true" />
                <div style="color: red;" id="invalid-Name"></div>
            </div>

            <div class="col-md-6">
                <!-- <label for="Email" class="form-label">Email</label> -->
                <s:textfield id="Email" placeholder="Enter Email" label="Email" key="user.email" cssClass="form-control" requiredLabel="true" />
                <div style="color: red;" id="invalid-email"></div>
            </div>

            <div class="col-md-6">
                <!-- <label for="mobile" class="form-label">Mobile Number</label> -->
                <s:textfield id="mobile" placeholder="Enter Mobile Number" label="Mobile Number" key="user.mobile" cssClass="form-control" maxlength="10" minlength="10" requiredLabel="true" />
                <div style="color: red;" id="invalid-mobile"></div>
            </div>

            <div class="col-md-6">
                <!-- <label for="datepicker-1" class="form-label">Date of Birth</label> -->
                <s:textfield id="datepicker-1" placeholder="Select DOB" label="DOB" key="user.dob" cssClass="form-control" readonly="true" requiredLabel="true" />
                <div style="color: red;" id="invalid-datepicker-1"></div>
            </div>

            <div class="col-md-6">
                <!-- <label for="Qualification" class="form-label">Qualification</label> -->
                <s:select id="Qualification" label="Qualification" name="user.qualification" 
                          list="#{'SSC' : 'SSC', 'HSC' : 'HSC', 'Graduation' : 'Graduation', 'BE' : 'BE'}" 
                          cssClass="form-select" requiredLabel="true" />
                <div style="color: red;" id="invalid-option"></div>
            </div>

           

            <div class="col-md-6" id="flexRadio">
                <!-- <label class="form-label">Gender</label> -->
                <div>
                    <s:radio label="Gender" name="user.gender" list="#{'male' : 'Male', 'female' : 'Female'}" cssClass="form-check-input" />
                    <div style="color: red;" id="invalid-gender"></div>
                </div>
            </div>

            <div class="col-md-6">
                <!-- <label for="password" class="form-label">Password</label> -->
                <s:textfield id="password" placeholder="Enter Password" label="Password" key="user.password" cssClass="form-control" requiredLabel="true" />
                <div style="color: red;" id="invalid-password"></div>
            </div>

            <div class="col-12 d-flex justify-content-between">
                <s:submit value="Submit" cssClass="btn btn-primary" />
            </div>
        </s:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script>
        $(document).ready(function() {
      
        
            // Initialize the datepicker
            $('#datepicker-1').datepicker({
                dateFormat: "mm/dd/yy",
                maxDate: new Date() // Set the maximum date to today
            });

          
        });
    </script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link
      href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container">
      <form
        class="row g-3 needs-validation my-2"
        novalidate
        id="myForm"
        ${user!=null }
        action="${pageContext.request.contextPath}/alluser"
        method="post"
      >
        <div class="col-md-6">
         <input
            type="hidden"
            class="form-control"
            id="id"
            name="id"
            value="${user!=null ?user.id:0 }"
          />
          <label for="Name" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            value="${user!=null ?user.name:"" }"
            required
            name="name"
          />
          <div style="color: red" id="invalid-Name"></div>
        </div>

        <div class="col-md-6">
          <label for="Email" class="form-label">Email</label>

          <input
            type="email"
            class="form-control"
            id="email"
            aria-describedby="inputGroupPrepend"
            required
            name="email"
            value="${user!=null ?user.email:''}"
          />
          <div style="color: red" id="invalid-email"></div>
        </div>

        <div class="col-md-6">
          <label for="mobile" class="form-label">Mobile Number</label>
          <input
            type="tel"
            class="form-control"
            id="mobile"
            name="mobile"
            
            maxlength="10"
            minlength="10"
            value="${user!=null ?user.mobile:"" }"
            required
          />
          <div style="color: red" id="invalid-mobile"></div>
        </div>

        <div class="col-md-6">
          <label for="dob" class="form-label">Date of Birth</label>
          <p>
            <input
              type="text"
              id="datepicker-1"
              required
              name="dob"
              placeholder="MM/DD/YYYY"
               value="${user!=null ?user.dob:"" }"
              readonly
            />
          </p>
          <div style="color: red" id="invalid-datepicker-1"></div>
        </div>

        <div class="col-md-6">
          <label for="State" class="form-label">Qualification</label>
        <select class="form-select" id="qualification" required name="qualification">
    <option value="" disabled ${user.qualification == null ? "selected" : ""}>Choose...</option>
    <option value="SSC" ${user.qualification == 'SSC' ? "selected" : ""}>SSC</option>
    <option value="HSC" ${user.qualification == 'HSC' ? "selected" : ""}>HSC</option>
    <option value="Graduation" ${user.qualification == 'Graduation' ? "selected" : ""}>Graduation</option>
    <option value="BE" ${user.qualification == 'BE' ? "selected" : ""}>BE</option>
</select>

          <div style="color: red" id="invalid-option"></div>
        </div>

       <div class="col-md-6" id="flexRadio">
    <label for="State" class="form-label" style="margin-right: 25px">Gender</label>
    <div>
        <input
            class="form-check-input"
            style="margin-right: 5px"
            type="radio"
            name="gender"
            id="male"
            value="male"
            ${user.gender == 'male' ? 'checked' : ''}
        />
        <label class="form-check-label" for="male" style="margin-right: 20px">Male</label>

        <input
            class="form-check-input"
            style="margin-right: 5px"
            type="radio"
            name="gender"
            id="female"
            value="female"
            ${user.gender == 'female' ? 'checked' : ''}
        />
        <label class="form-check-label" for="female">Female</label>
        <div style="color: red" id="invalid-gender"></div>
    </div>
</div>

        
        
        

        <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            class="form-control"
            id="password"
            required
            name="password"
            value="${user.password !=null ?user.password :"" }"
          />
          <div style="color: red" id="invalid-password"></div>
        </div>

        <div class="col-md-6">
          <label for="cPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="cpassword" required    value="${user.password !=null ?user.password :"" }"/>
          <div style="color: red" id="invalid-cpassword"></div>
          <!-- <div style="color: red;" id="missmatch" ></div> -->
        </div>

        <div class="col-12 d-flex justify-content-between">
          <button class="btn btn-primary" id="submit" type="submit">
            Submit form
          </button>
         <button class="btn btn-danger" id="reset-form" ${user != null ? "disabled" : ""}>Reset form</button>

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
        console.log("Jquery Working");

        $("#datepicker-1").datepicker({
          maxDate: 0,
          dateFormat: "dd/mm/yy",
        });

        var today = new Date();
        var dd = String(today.getDate()).padStart(2, "0");
        var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
        var yyyy = today.getFullYear();
        today = mm + "/" + dd + "/" + yyyy;
        $("#datepicker-1").val(today);

        function name(name) {
          console.log("name ", name.length);
          if (name.length < 2) {
            $("#invalid-Name").text("Please enter a valid Name");
            return false;
          } else {
            $("#invalid-Name").text("");
            $("#name").css("background-color", "white");
            return true;
          }
        }

        function email(email) {
          var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
          const isValidEmail = emailPattern.test(email);
          if (!isValidEmail) {
            $("#invalid-email").text("Please enter a valid Email");
            return false;
          } else {
            $("#email").css("background-color", "white");
            $("#invalid-email").text("");
            return true;
          }
        }

        function mobile(mobile) {
          const mobileFilter = /[6-9]{1}[0-9]{9}/;
          const isValidMobile = mobileFilter.test(mobile);
          if (!isValidMobile) {
            $("#invalid-mobile").text("Please enter a valid number");
            return false;
          } else {
            $("#invalid-mobile").text("");
            $("#mobile").css("background-color", "white");
            return true;
          }
        }

        function qualification() {
          if (!$("#qualification").val()) {
            $("#invalid-option").text(`Please enter valid qualification`);
            $("#qualification").css("background-color", "red");
            return false;
          } else {
            $("#invalid-option").text(``);
            $("#qualification").css("background-color", "white");
            return true;
          }
        }

        function checkPassword(pass) {
          console.log("check");
          const cpass = $("#cpassword").val();
          console.log(pass, "  ", cpass);
          if (pass) {
            $("#invalid-password").text("");
            $("#password").css("background-color", "white");
          }
          if (cpass !== pass) {
            $("#invalid-cpassword").text("Password missmatch");
            return false;
          } else {
            console.log("match");
            $("#invalid-cpassword").text("");
            return true;
          }
        }

        $("#name").on("input", function () {
          name($("#name").val());
        });

        $("#email").on("input", function () {
          email($("#email").val());
        });

        $("#mobile").on("input", function () {
          mobile($("#mobile").val());
        });

        $("#qualification").on("change", function () {
          qualification();
        });

        $("#password").on("input", function () {
          console.log("pass");
          checkPassword($("#password").val());
        });

        $("#cpassword").on("input", function () {
          console.log("cpass");
          checkPassword($("#password").val());
        });

        $("#gender").on("change", function () {
          console.log(
            "11 " + $('input[name="flexRadioDefault"]:checked').val()
          );

          if ($('input[name="gender"]:checked').val()) {
            $("#invalid-gender").text(``);
          }
        });

        $("#myForm").on("submit", function (e) {
          console.log("submit");
          let isvalid = true;
          if (!name($("#name").val())) {
            $("#invalid-Name").html(`<span>Please Enter name </span>`);
            $("#name").css("background-color", "red");
            isvalid = false;
            console.log(1);

            console.log(isvalid);
          }
          if (!email($("#email").val())) {
            $("#invalid-email").text(`Please enter valid email`);
            $("#email").css("background-color", "red");
            console.log(2);
            isvalid = false;
          }
          if (!mobile($("#mobile").val())) {
            $("#invalid-mobile").text(`Please enter valid number`);
            $("#mobile").css("background-color", "red");
            isvalid = false;
            console.log(3);
          }
          if (!qualification()) {
            // $("#invalid-option").text(`Please enter valid qualification`);
            // $("#1ualification").css("background-color", "red");
            isvalid = false;
            console.log(4);
          }
          if (!checkPassword($("#password").val())) {
            isvalid = false;
            console.log(5);
          }
          if (!$('input[name="gender"]:checked').val()) {
            $("#invalid-gender").text(`Please select gender`);
            console.log($('input[name="gender"]:checked').val());
            console.log(6);
            isvalid = false;
          }

          if (!$("#password").val()) {
            $("#invalid-password").text(`Please enter password`);
            $("#password").css("background-color", "red");
            isvalid = false;
          } else if (!$("#cpassword").val()) {
            $("#invalid-cpassword").text(`Please confirm password`);
            $("#cpassword").css("background-color", "red");
            isvalid = false;
          }
          if (!isvalid) {
            console.log("--------");

            e.preventDefault();
          }
        });
      });
    </script>
  </body>
</html>

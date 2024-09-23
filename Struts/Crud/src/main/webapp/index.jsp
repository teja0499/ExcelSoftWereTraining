<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

  </head>
  <link

    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous"
  />
  <body>
    <div class="container">
     <form action="loginForm"  method="post" class="row g-3 needs-validation" >
        <div class="col-md-6">
          <label for="Name" class="form-label">Name</label>
          <input type="text" class="form-control" id="Name" value="" required name="name" />
          <div  style="color: red;" id="invalid-Name">   </div>
        </div>
        
        <div class="col-md-6">
          <label for="Email" class="form-label">Emaill</label>
          
            <input
              type="email"
              class="form-control"
              id="Email"
              name="email"
              aria-describedby="inputGroupPrepend"
              required
            />
            <div style="color: red;" id="invalid-email"></div>
         
        </div>

        <div class="col-md-6">
          <label for="mobile" class="form-label">Mobile Number</label>
          <input
            type="tel"
            class="form-control"
            id="mobile"
            name="mobile"
            value=""
            maxlength=10
            minlength=10
           
            required
          />
          <div style="color: red;" id="invalid-mobile"></div>
        </div>

        <div class="col-md-6">
          <label for="dob" class="form-label">Date of Birth</label>
          <p> <input type="text" id="datepicker-1" name="dob" required placeholder="MM/DD/YYYY" readonly></p>
          <div style="color: red;"  id="invalid-datepicker-1"></div>
        </div>

        <div class="col-md-6">
          <label for="State" class="form-label">Qualification</label>
          <select class="form-select" id="Qualification" name="Qualification" required>
            <option selected disabled value="">Choose...</option>
            <option>SSC</option>
            <option>HSC</option>
            <option>Graduation</option>
            <option>BE</option>
          </select>
          <div style="color: red;" id="invalid-option"></div>
        </div>

        <div class="col-md-6" id="flexRadio">
          <label for="State" class="form-label" style="margin-right: 25px;">Gender</label>
          <div>
          <input class="form-check-input" style="margin-right: 5px;" type="radio" name="gender" id="flexRadioDefault1" value="male">
          <label class="form-check-label" for="flexRadioDefault1" style="margin-right: 20px;">Male</label>
        
          <input class="form-check-input" style="margin-right: 5px;" type="radio" name="gender" id="flexRadioDefault2" value="female">
          <label class="form-check-label" for="flexRadioDefault2">Female</label>
          <div style="color: red;"  id="invalid-gender"></div>
        </div>
      </div>

        <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" required  name="password"/>
          <div style="color: red;"  id="invalid-password"></div>
        </div>

        <div class="col-md-6">
          <label for="cPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="cPassword" required />
          <div style="color: red;" id="invalid-cpassword" ></div>
          <!-- <div style="color: red;" id="missmatch" ></div> -->
        </div>

        <!-- <div class="col-12">
          <div class="form-check">
            <input
              class="form-check-input"
              type="checkbox"
              value=""
              id="invalidCheck"
              required
            />
            <label class="form-check-label" for="invalidCheck">
              Agree to terms and conditions
            </label>
            <div style="color: red;">
             
            </div>
          </div>
        </div> --> 

        <div class="col-12 d-flex justify-content-between">
<!--           <button class="btn btn-primary" id="submit" type="submit">
             <input type="" />
 -->            
  <input type="submit" value="submit"  class="btn btn-primary" id="submit" />
 
          </button>
          <button class="btn btn-danger" id="reset-form" >
            Reset form
          </button>
          
         
        </div>
      </form>
      <div class="container">
      	<form action="viewAll" style="display: inline;">
							<input type="hidden" name="id" value="<s:property value='id' />" />
							<input type="submit" value="View all" class="btn btn-success my-2" />
		</form>
		</div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
     <script src="./Web-INF/JQuery/jquery-3.7.1.min.js"></script> 
   <script>
    /**
     * 
     */
    $(document).ready(function () {
      $("#reset-form").click(function () {
        form.reset();
      });


      var today = new Date();
      var dd = String(today.getDate()).padStart(2, "0");
      var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = today.getFullYear();
      today = mm + "/" + dd + "/" + yyyy;

      var mobileFilter = /[6-9]{1}[0-9]{9}/;

      function isValidMobile(mob) {
        return mobileFilter.test(mob);
    }

      $("#mobile").on("input", function () {
        const mob = $("#mobile").val();
        console.log(mob.length);

        // if (mob.length !== 10) {
        //   $("#invalid-mobile").text("Please enter a valid number");
        // } else {
        //   $("#invalid-mobile").text("");
        //   $("#mobile").css("background-color", "white");
        // }
        if (!isValidMobile(mob)) {
          $("#invalid-mobile").text("Please enter a valid number");
          
        } else {
          $("#invalid-mobile").text("");
          $("#mobile").css("background-color", "white");
        }
      });

      $("#Name").on("input", function () {
        const mob = $("#Name").val();
        
        if (mob.length === 0) {
          $("#invalid-Name").text("Please enter a valid Name");
        } else {
          $("#invalid-Name").text("");
          $("#Name").css("background-color", "white");
          
        }
      });

      var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

        function isValidEmail(email) {
            return emailPattern.test(email);
        }




      $("#Email").on("input", function () {
        const email = $("#Email").val();
        console.log(email.length);

        if (!isValidEmail(email)) {
          $("#invalid-email").text("Please enter a valid Email");
        } else {
          $("#Email").css("background-color", "white");
          $("#invalid-email").text("");

        }
      });



      $("#cPassword").on("input", function () {
        const cPassword = $("#cPassword").val();
        const password = $("#password").val();

        if (cPassword !== password) {
          $("#invalid-cpassword").text("Password missmatch");
        } else {
          $("#invalid-cpassword").text("");
        }
      });


      $("#password").on("input", function () {
        
        const password = $("#password").val();
        const cPassword = $("#cPassword").val();
        if (cPassword !== password) {
          $("#invalid-cpassword").text("Password missmatch");
        } else {
          $("#invalid-cpassword").text("");
        }
        if (password) {
          $("#invalid-password").text("");
          $("#password").css("background-color", "white");
        }
      });

      

      $( "#datepicker-1" ).datepicker({
        maxDate:0
      });


      $("#datepicker-1").on("change", function () {
          console.log( $("#datepicker-1").val());
          maxDate: new Date()
          // $("#invalid-datepicker-1").css("background-color", "white");
          
        if (today < $("#datepicker-1").val()) {
          
            $("#invalid-datepicker-1").text(`Please select a propar date`);
          }
          else{
            $("#invalid-datepicker-1").text(``);
            $("#datepicker-1").css("background-color", "white");
          }
      });

      $("#Qualification").on("change", function () {
          
        if (!$("#Qualification").val()) {
            $("#invalid-option").text(`Please enter valid qualification`);
            $("#Qualification").css("background-color", "red");
          }
        else{
            $("#invalid-option").text(``);
            $("#Qualification").css("background-color", "white");
        }
      });


      $("#flexRadio").on("change", function () {
          
        if ($('input[name="gender"]:checked').val()) {
          $("#invalid-gender").text(``);
          }

      });
      

        
    });

    </script>
  </body>
</html>

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
      
    if ($('input[name="flexRadioDefault"]:checked').val()) {
      $("#invalid-gender").text(``);
      }

  });
  

  $("#submit").click(function (e) {
    var form = $(".needs-validation")[0];
    e.preventDefault();

    if ($("#password").val() === $("#cPassword").val()) {
        var selectedGender = $('input[name="flexRadioDefault"]:checked').val();
      console.log($("#Name").val());
      console.log($("#Email").val());
      console.log($("#mobile").val());
      console.log($("#datepicker-1").val());
      console.log($("#Qualification").val());
      console.log($("#password").val());
      console.log($("#Email").val().includes("."));

      if (!$("#Name").val()) {
        $("#invalid-Name").html(`<span>Please Enter name </span>`);
        $("#Name").css("background-color", "red");
      }
      if (!$("#Email").val()) {
        $("#invalid-email").text(`Please enter valid email`);
        $("#Email").css("background-color", "red");
      }
      if (!$("#mobile").val()) {
        $("#invalid-mobile").text(`Please enter valid number`);
        $("#mobile").css("background-color", "red");
      }
      if (!$("#datepicker-1").val()) {
        $("#invalid-datepicker-1").text(`Please select a date`);
        $("#datepicker-1").css("background-color", "red");
      }
      if (!$("#Qualification").val()) {
        $("#invalid-option").text(`Please enter valid qualification`);
        $("#Qualification").css("background-color", "red");
      }
      if (!$('input[name="flexRadioDefault"]:checked').val()) {
        $("#invalid-gender").text(`Please select gender`);
      }
      
      if (today < $("#datepicker-1").val())  {
        console.log("hi");
        $("#datepicker-1").css("background-color", "red");
        $("#invalid-datepicker-1").text(`Please select a propar date`);
        return;
      }
      else{
        $("#invalid-datepicker-1").css("background-color", "white");
      }
      if (!$("#password").val()) {
        $("#invalid-password").text(`Please enter password`);
        $("#password").css("background-color", "red");
      } else if (!$("#cPassword").val()) {
        $("#invalid-cpassword").text(`Please confirm password`);
        $("#cPassword").css("background-color", "red");
      }
      if (!isValidMobile($("#mobile").val()) || !isValidEmail($("#Email").val())) {return;}
      if (
        $("#Name").val() &&
        $("#Email").val() &&
        $("#mobile").val() &&
        $("#datepicker-1").val() &&
        $("#Qualification").val() &&
        selectedGender &&
        $("#password").val() &&
        $("#cPassword").val()
      ) {
        console.log("Form submitted successfully!");
        form.reset();
      }
    } else {
      $("#invalid-cpassword").text(`Password Mismatch`);
      return;
    }
  });
});

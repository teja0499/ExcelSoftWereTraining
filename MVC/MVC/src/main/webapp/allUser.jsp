<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>User List</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>
  <style>
    table {
      border-collapse: collapse;
      background-color: #f7f7f7;
    }
    th,
    td {
      border: 1px solid #000;
      text-align: center;
      padding: 8px;
    }
    thead th {
      position: sticky;
      top: 0;
      background-color: #dcdcde;
      z-index: 2;
    }
    tbody {
      max-height: 340px;
      overflow-y: auto;
      display: block;
      width: 100%;
      scrollbar-width: none;
    }
    thead,
    tbody tr {
      display: table;
      width: 100%;
      table-layout: fixed;
    }
  </style>
  <body>
    <h1 class="text-center">All Users</h1>
    <div class="container">
      <form class="d-flex my-2" role="search">
        <input
          class="form-control me-2"
          type="search"
          placeholder="Search"
          id="search"
          aria-label="Search"
        />
        <button class="btn btn-outline-success" id="searchbtn" type="button">
          Search
        </button>
      </form>

      <div
        style="
          height: 400px;
          overflow-y: auto;
          width: 75rem;
          scrollbar-width: none;
        "
      >
        <table
          class="table table-border border-dark"
          style="border-bottom: 1px solid black"
        >
          <thead>
            <tr>
              <th style="width: 2rem">ID</th>
              <th>Name</th>
              <th>Gender</th>
              <th>DOB</th>
              <th>Qualification</th>
              <th style="width: 15rem">Email</th>
              <th>Mobile</th>

              <th>Action</th>
            </tr>
          </thead>
          <tbody class="text-center" id="userData">
            <c:forEach var="user" items="${users}" varStatus="status">
              <tr>
                <td style="width: 2rem" id="id">${user.id}</td>

                <td>${user.name }</td>
                <td>${user.gender}</td>
                <td>${user.dob}</td>
                <td>${user.qualification}</td>
                <td style="width: 15rem">${user.email}</td>
                <td>${user.mobile}</td>

                <td>
                  <form
                    action="${pageContext.request.contextPath}/deleteuser/${user.id}"
                    method="post"
                    style="display: inline"
                  >
                    <input
                      type="submit"
                      value="Delete"
                      class="btn btn-danger"
                    />
                  </form>
                  <form
                    action="${pageContext.request.contextPath}/edituser/${user.id}"
                    method="post"
                    style="display: inline"
                  >
                    <input
                      type="submit"
                      value="Edit"
                      class="btn btn-secondary"
                    />
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>

    <script>
      $(document).ready(function () {
        console.log("jquery start");

        $("#searchbtn").on("click", function () {
          const searchValue = $("#search").val().trim(); // Get and trim search value
          console.log(searchValue);

          $.ajax({
            url: "http://localhost:8080/MVC/findbyname",
            data: { name: searchValue },
            type: "GET",
            beforeSend: function () {
              console.log("Request initiated...");
            },
            success: function (response, status) {
               $("#userData").empty();
              console.log("Success:", response);
              console.log("Status:", status);
              let str = "";
              console.log(response.length);
              
              if(response.length)
              {
              for (let i = 0; i < response.length; i++) {
                const {
                    mobile,
                    email,
                    name,
                    dob,
                    gender,
                    qualification,
                    password,
                    id
                  } = response[i];


              str+=  "<tr>" +
                    "<td style='width: 2rem'>" +id +"</td>" +
                    "<td>" +name +"</td>" +
                    "<td>" +gender +"</td>" +
                    "<td>" +dob +"</td>" +
                    "<td>" +qualification +"</td>" +
                    "<td style='width: 15rem'>" +email +"</td>" +
                    "<td>" +mobile +"</td>" +
                    // "<td>" +mobile +"</td>" +
                    "<td>"+
                 "<form action='http://localhost:8080/MVC/deleteuser/"+id+"' style='display: inline'  class='mx-1'>"+
                    "<input type='submit' value='Delete' class='btn btn-danger'  />"+
                  "</form>"+


                  "<form action='http://localhost:8080/MVC/edituser/"+id+"' method='post' style='display: inline' >"+
                  "<input type='submit' value='Edit' class='btn btn-secondary' />"+
                 " </form>"+

                  "</td>"+

                 
               " </tr>";
            }
            $("#userData").append(str);
        }else{
            $("#userData").append(
                  '<tr><td colspan="8">No results found</td></tr>'
                );
        }

            },
            error: function (xhr, status, error) {
              console.log("Request failed");
              console.log("Status:", status);
              console.log("Error:", error);
            },
            complete: function (xhr, status) {
              console.log("Request completed with status:", status);
            },
          });
        });
      });
    </script>
  </body>
</html>

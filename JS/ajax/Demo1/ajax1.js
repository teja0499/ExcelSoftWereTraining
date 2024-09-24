console.log("hi Tejas");

let fetchbtn = document.getElementById(`fetchbtn`);

// console.log(fetchbtn);

fetchbtn.addEventListener("click", btnClickHandler);

function btnClickHandler() {
  console.log("hii btnClickHandler");

  const data = `{
        "email": "emma.wong@reqres.in",
        "first_name": "Emma",
        "last_name": "Wong",
        "avatar": "https://reqres.in/img/faces/3-image.jpg"
    }`;

  // instantiate an object
  const xhr = new XMLHttpRequest();

  //open object/url/resoure or access the resourse   first args is type of req , sec args is resource or api, third is want to run Asynchronous then true else it eill false for synchronous
  //   const isWoring=  xhr.open('GET','./abcd.txt',true);
  // xhr.open('GET','https://dummyjson.com/posts',true);
//   xhr.open("GET", "https://jsonplaceholder.typicode.com/comments", true);

  xhr.open('POST','https://reqres.in/api/users',true)
  xhr.getResponseHeader('content-type','application/json')

  //     //this work when resource is start loading progresss (optional)
  xhr.onprogress=function(){
      console.log("progress");
  }

  // this is old function
  xhr.onreadystatechange = function () {
    console.log("Xhr ready state ", xhr.readyState);
  };

  // fuction when loading is complete
  xhr.onload = function () {
    console.log(xhr.status);

    if (xhr.status === 200) {
      console.log(this.responseText);
    } else if (xhr.status === 201) {
      console.log(this.responseText);
    } else {
      console.log("failse to reload");
    }
  };
  console.log("end");
//   xhr.send();
  xhr.send(data) // for post request
}


const popbtn=document.getElementById('popbtn')

popbtn.addEventListener("click",popHandler)

function popHandler(){
    console.log("popHandler");
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "https://jsonplaceholder.typicode.com/comments?_limit=10", true);
    xhr.open("GET", "https://jsonplaceholder.typicode.com/comments", true);
    

    xhr.onprogress=function(){
        console.log("progress");
    }

    xhr.onload = function () {
        console.log(xhr.status);
    
        if (xhr.status === 200) {
            const obj=JSON.parse(this.responseText)
            const ApiData=document.getElementById('ApiData')
          console.log(obj[1]);
        
        let str = `
        <tr>
            <th>Id</th>
            <th>PostId</th>
            <th>Name</th>
            <th>Email</th>
            <th>Content</th>
        </tr>`;
    
    // Iterate over the object (API response)
    for (let id in obj) {
        console.log(id);
        str += `<tr>
            <td>${id}</td>
            <td>${obj[id].postId}</td>
            <td>${obj[id].name}</td>
            <td>${obj[id].email}</td>
            <td>${obj[id].body}</td>
        </tr>`;

    }
    
    // Insert the final table into the DOM
    ApiData.innerHTML = `<table>`+str+`</table>`;
    
        } else {
          console.log("failse to reload");
        }
      };
      xhr.send();
    
}

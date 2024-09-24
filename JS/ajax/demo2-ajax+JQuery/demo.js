$(document).ready(
    console.log("hello tejas"),

   str=`<tr>
   <th scope="col">ID</th>
   <th scope="col">Post Id</th>
   <th scope="col">Name</th>
   <th scope="col">Email</th>
   <th scope="col">Body</th>
   </tr>`,
    $('#fetchbtn').click(function(){
        console.log("click fetchbtn");
        $.ajax({
            url:'https://jsonplaceholder.typicode.com/comments',
            type:'GET',
            beforeSend:function(){
                console.log("log inside before send");
            },
            success:function(response,status){
                console.log("on success");
                console.log(status);
                console.log(response);
                for(let i=0;i<response.length;i++)
                {
                    const {id,postId,body,email,name}=response[i]
                    console.log(id);
                    
                    str+=`<tr>
                    <td>${id}</td>
                    <td>${postId}</td>
                   <td>${name.length<=25?name : (name.substring(0,22)+'...')}</td>
                    <td>${email.length<=25?email : (email.substring(0,22)+'...')}</td>
                     <td>${body.length<=25?body : (body.substring(0,22)+'...')}</td>
                    </tr>`
                }
                // apidata.html=str
                $('tbody').append(str)
            },
            error:function(error , status){
                console.log("on fail");
                console.log(status);
                console.log(error);
            }
        })
    })
)
   
    

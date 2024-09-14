$(document).ready(function(){



//     $('h1').click(function(){
// console.log("jsq working ");
// // $(this).hide()
// })  

// $('h1').hover(function(){
// console.log("jsq hover working ");
// // $(this).hide()
// }, function(){
// console.log("Leave ");

// })  

//    $('h1').click(function(){
//     console.log("jsq working ");
//     // $(this).hide()

//    })

// $('h1').on({
//     click:function(){
//         console.log("on click function");
//     }
// })

// $('#wiki').hide(1000,function(){
//     console.log("hide function");
// })

// $('#wiki').show(1000,function(){
//     console.log("Show function");
// })

// $('#but').click(function(){
//     // $('#wiki').toggle(1000);
   
//     $('#wiki').slideToggle(1000)
// })

// $('#but').click(function(){
//     // $('#wiki').fadeOut(1000);
//     // $('#wiki').fadeToggle(1000)
//     // $('#wiki').fadeTo('slow',0.5,function(){
//     //     console.log("fade to complete");    
//     // })
//      $('#wiki').slideUp(1000,function(){
//         console.log("slide up");
        
//      })
   
// })

// $('#butt').click(function(){
//     // $('#wiki').fadeIn(1000);
//     // $('#wiki').fadeTo('slow',1,function(){
//     //     console.log("fade to complete");    
//     // })
//      $('#wiki').slideDown(1000,function(){
//         console.log("Slide down");
        
//      })
// })

// animation

// $('#but').click(function(){
//        $('#wiki').animate({opacity:0.3,height :'150px',width:'350px'},'slow')
       
//     })

$('#abc').click(function(){
    // $('body').remove();
    $('body').html()
    console.log( $('body').html());
    
    $('#wiki').html(`<span>Hello tejas</span>`)
    // $('#wiki').text("Hello tejas")
    console.log( $('body').html());
    console.log("Remove");
    
})

})

$(document).ready(function(){
$("h1").click(function(){
	alert("You clicked me!");
	$(this).hide();
    }
);
$("p").click(function(){popAlert();});
$("input").focus(function () {
  $(this).css("background-color", "#cccccc");
});
$("input").blur(function () {
  $(this).css("background-color", "#ffffff");
});
$( "form" ).submit(function(){
    if ( $("#name").val() !== "Chad"){
        $("#name").css("background-color","red");
        alert("Name must be Chad");
        return false;
    }else{
        return true;
    }
});
$("#toggleVisability").click(function(){
   $("#disappearingText").toggle(); 
});
$("#toggleFade").click(function(){
   $("#disappearingText").fadeToggle(1000); 
});
$("#calvin").dblclick(function(){
  $("#calvin").animate({
            left: '250px',
            height: '+=150px',
            width: '+=150px'
        });
});
});



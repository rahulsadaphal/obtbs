<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css\slider.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="black">
<div class="slider-containerAdmin">
	<div class="mySlides1 fade"><img src="images\img1.jpg"></div>
	<div class="mySlides1 fade"><img src="images\img11.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img2.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img3.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img4.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img12.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img5.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img6.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img7.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img8.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img9.jpg"></div>
	<div class="mySlides1 fade "><img src="images\img10.jpg"></div>
</div>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides1");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex> slides.length) {slideIndex = 1}    
    slides[slideIndex-1].style.display = "block";  
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

</body>
</html>
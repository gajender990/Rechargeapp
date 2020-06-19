<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/welcomestyle.css">
</head>
<body>
	<div class="header">
		  <div id="image">
		      <img src="Images/logo.jpg">
		  </div>	
		  <div id=buttons>
		    <a href="/login" class="button signup">${checkuser}</a>
		    <a href="/signup" class="button Login">${signdetails}</a>
		  </div>	
	</div>
	

<div class="slider">
    <figure>
      
        <img src="Images/airtel3.png" alt="">
  
        <img src="Images/aitel1.png" alt="">
  
        <img src="Images/aitel2.png" alt="">

        <img src="Images/airtel4.png" alt="">
      
    </figure>
</div>
<br>
<div class="footer">
  <div class="red" style="text-align: center;">
    <h1>Get Your</h1>
    <p style="font-size: 40px;">Recharge</p>
    <h1>Done here</h1>
  </div>
  <div class="amount">
    <p>Phone Number</p>
    <form action="/try">
      <input type="number" name="phoneno" minlength="10" maxlength="10" placeholder="Phone Number">
      <br>
      <button class="amubutton" type="submit">Recharge</button>
    </form>
  </div>
</div>
</body>
</html>
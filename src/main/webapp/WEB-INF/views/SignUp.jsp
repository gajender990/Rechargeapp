<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/loginstyle1.css">
</head>
<body>
<div class="login-page">
  <div class="form">	
   <form class="login-form" action="/adduser">
      <input type="text" placeholder="name" name="name" />
      <input type="text" placeholder="Username" name="username"/>
      <input type="passsword" placeholder="Password" name="password"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
  </div>
</div>
</body>
</html>
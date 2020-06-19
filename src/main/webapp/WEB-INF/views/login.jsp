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
 
    <form class="login-form" action="/try">
    	${credentials}
      <input type="text" type="reset" placeholder="username" name="username"/>
      <input type="password" type="reset" placeholder="password" name="password"/>
      <button type="submit">login</button>
      <p class="message">Not registered? <a href="/signup">Create an account</a></p>
    </form>
  </div>
</div>
</body>
</html>
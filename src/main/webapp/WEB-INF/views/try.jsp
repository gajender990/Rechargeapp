<%@taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix= "c" %>  

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

	<h2>Enter your Recharge details</h2>
	<form action="Rechargedone">
		<input type="text" placeholder="${number}">
		<br>
		<br>
		<input type="text" placeholder="${amount}">
		<br>
		<br>
		<button type="submit">Recharge</button>
	</form>	
	<table class="table">
	 	<thead>
		<tr class="table-row">
			<th>SID</th>
			<th>PACK DETAILS</th>
			<th>VALIDITY</th>
			<th>AMOUNT</th>
			<th>Recharge</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="r" items="${recharge}">
		<tr>
			<td>${r.sid}</td>
			<td>${r.packdetails}</td>
			<td>${r.validity}</td>
			<td>${r.amount}</td>
			<!--<td><a href="/addamount">Add</a></td>-->
			<td>
			<form action="/addamount">
   
      			<button name="Amount" value="${r.amount}" type="submit">Recharge</button>
   			 </form>
			</td>
		</tr>
		</c:forEach>
		</tbody>	
	</table>


</body>
</html>
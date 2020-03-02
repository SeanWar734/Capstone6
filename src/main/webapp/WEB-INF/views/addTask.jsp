<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
		<link href="/style.css" rel="stylesheet" /> 
	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>

	<section class="container-fluid">
		<h2>New Task</h2>
		<h3>Currently Logged In: ${user.name}</h3>
	</section>

	<section>
		<form method="post">
			<label>Title</label> <input type="text" name="name" required>
			<label>Description</label> <input type="text" name="description" required> 
			<label>Due Date</label> <input type="date" name="dueDate" required>
			<label>Complete</label> <input type="checkbox" name="complete" value="true"> 
			
			<input type="hidden" name="user" value="${user.id}">
						
			<button type="submit" class="btn btn-warning">GO</button>
		</form>
	</section>
	<a href="/" class="btn btn-secondary">Back to Home</a>
</body>
</html>
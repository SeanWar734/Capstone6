<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="/style.css" rel="stylesheet" /> 

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="partials/header.jsp" %>

	
	<section class="container-fluid">
		<h2>Create a new User</h2>
	</section>

	<section>
		<form method="post">
			<label>Name</label> <input type="text" name="name" required>
			<label>Password</label> <input type="password" name="password" required>
			<button type="submit" class="btn btn-warning">GO</button>
		</form>
	</section>
	<a href="/" class="btn btn-warning">Quit</a>


</body>
</html>
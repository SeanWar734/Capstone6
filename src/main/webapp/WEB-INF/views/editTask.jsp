<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<main class="container">
		<h1>Edit</h1>

		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form action="/editTask/confirm" method="post">
			<!-- We need to keep the ID and submit it with the form, but we don't want the user to have to see it. -->
			<input type="hidden" name="id" value="${task.id}" />
			
			
			<div class="form-group">
				<label for="name">Name</label>
				<input class="form-control" type="text" id="name" name="name" value="${task.name}" required autocomplete="off">
			</div>


			<div class="form-group">
				<label for="description">Description</label> 
				<input class="form-control" type="text" id="description" name="description" value="${task.description}" required>
			</div>
			
			
			<div class="form-group">
				<label for="dueDate">Due Date</label> 
				<input class="form-control" id="dueDate" type="date" name="dueDate" value="${task.dueDate}" required>
			</div>
			
			
			<div class="form-group">
				<label for="complete">Complete</label> 
				<input id="complete" type="checkbox" name="complete" value="true">
			</div>
			
			<div>
				<label>Who's task is it anyway</label> <select name="user">
					<c:forEach var="user" items="${users}">
						<option value="${user.id}">${user.name}</option>
					</c:forEach>
				</select>
			</div>			
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/" class="btn btn-link">Cancel</a>
		</form>
	</main>
</body>
</html>
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
	<main>
		<div>
			<c:if test="${user ne null}">
				<h2>Currently Logged in: ${user.getName()}</h2>
			</c:if>

			<section class="jumbotron">
				<table>
					<tr>
						<th>Task</th>
						<th>Description</th>
						<th>Due Date</th>
						<th>Is It Complete?</th>
					</tr>
					<c:forEach items="${tasks}" var="task">

						<tr>
							<td>${task.name}</td>
							<td>${task.description}</td>
							<td>${task.dueDate}</td>
							<td>${task.complete}</td>
							<td><a href="/editTask?id=${task.id}">Edit</a></td>
							<td><a href="/deleteTask?id=${task.id}">Delete</a>
						</tr>
					</c:forEach>
				</table>

			</section>
			<c:if test="${user ne null}">
				<a class="btn btn-warning" href="/addTask?userId=${user.id}">Add Task</a>
			</c:if>
		</div>
	</main>
</body>
</html>
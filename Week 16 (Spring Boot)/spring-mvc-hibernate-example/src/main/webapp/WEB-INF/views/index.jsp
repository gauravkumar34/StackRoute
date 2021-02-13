<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>


	<form method="post" action="<c:url value="/addUser"/>">
		<div class="mb-3">
			<label for="inputEmail" class="form-label">Email address</label> <input
				type="email" name="email" value="${userItem.email}"
				class="form-control" id="inputEmail">
		</div>
		<div class="mb-3">
			<label for="inputName" class="form-label">Name</label> <input
				type="text" name="name" value="${userItem.name}"
				class="form-control" id="inputName">
		</div>
		<div class="mb-3">
			<label for="inputCity" class="form-label">City</label> <input
				type="text" name="city" value="${userItem.city}"
				class="form-control" id="inputCity">
		</div>
		<c:if test="${empty userItem.email}">
			<button type="submit" class="btn btn-primary">Add</button>
		</c:if>

		<c:if test="${!empty userItem.email}">
			<button type="submit" class="btn btn-primary">Update</button>
		</c:if>
	</form>

	<c:if test="${!empty userList}">
		<table class="table">
			<thead>
				<tr>

					<th scope="col">Email</th>
					<th scope="col">Name</th>
					<th scope="col">City</th>
					<th scope="col">Creation Date</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.email}</td>
						<td>${user.name}</td>
						<td>${user.city}</td>
						<td>${user.creationDate}</td>
						<td><div class="btn-group" role="group"
								aria-label="Basic example">
								<a href="<c:url value="/updateUser/${user.email}"/>"><button
										type="button" class="btn btn-warning">Edit</button></a> <a
									href="<c:url value="/deleteUser/${user.email}"/>"><button
										type="button" class="btn btn-danger">Delete</button></a>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->
</body>
</html>
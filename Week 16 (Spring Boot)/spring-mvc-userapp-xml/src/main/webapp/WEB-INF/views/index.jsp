<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
	integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX"
	crossorigin="anonymous">

<title>User App</title>
</head>
<body>



	<form method="post" action="<c:url value="/addUser" />">
		<div class="form-group">
			<label for="exampleInputName">Name</label> <input type="text"
				class="form-control" id="exampleInputName" name="name"
				value="${userItem.name}">
		</div>

		<div class="form-group">
			<label for="exampleInputCity">City</label> <input type="text"
				class="form-control" id="exampleInputCity" name="city"
				value="${userItem.city}">
		</div>


		<div class="form-group">
			<label for="exampleInputEmail">Email</label> <input type="email"
				class="form-control" id="exampleInputEmail" name="email"
				value="${userItem.email}">
		</div>
		<c:if test="${!empty userItem.email}">
			<button type="submit" class="btn btn-primary">Update</button>
		</c:if>


		<c:if test="${empty userItem.email}">
			<button type="submit" class="btn btn-primary">Add</button>
		</c:if>


	</form>

	<c:if test="${!empty userList}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">City</th>
					<th scope="col">Email</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.name}</td>
						<td>${user.city}</td>
						<td>${user.email}</td>
						<td>
							<div class="btn-group" role="group" aria-label="Basic example">
								<a href="<c:url value="/updateUser/${user.email}" />"><button
										type="button" class="btn btn-success">Edit</button></a> <a
									href="<c:url value="/deleteUser/${user.email}" />"><button
										type="button" class="btn btn-danger">Delete</button></a>

							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js"
		integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J"
		crossorigin="anonymous"></script>
</body>
</html>


</body>
</html>
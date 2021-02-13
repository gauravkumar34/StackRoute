
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
	<div class="container">
	<form method="post" action="<c:url value="/saveNote"/>">
	<div class="mb-3">
    <label for="inputNoteId" class="form-label">NoteId </label>
    <input type="text" class="form-control" name="noteId" id="inputNoteId" value="${noteItem.noteId }">
  </div>
  <div class="mb-3">
    <label for="inputTitle" class="form-label">Title </label>
    <input type="text" class="form-control" name="noteTitle" id="inputTitle" value="${noteItem.noteTitle }">
  </div>
  <div class="mb-3">
    <label for="inputContent" class="form-label">Content </label>
    <input type="text" class="form-control" name="noteContent" id="inputContent" value="${noteItem.noteContent }">
  </div>
  <div class="mb-3">
    <label for="inputStatus" class="form-label">Status </label>
    <input type="text" class="form-control" name="noteStatus" id="inputStatus" value="${noteItem.noteStatus }">
  </div>
 
  <c:if test="${!empty noteItem.noteId}">
			<button type="submit" class="btn btn-primary">Update</button>
		</c:if>


		<c:if test="${empty noteItem.noteId}">
			<button type="submit" class="btn btn-primary">Add</button>
		</c:if>
 
</form>
<c:if test="${!empty noteList }">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Note id</th>
      <th scope="col">Title</th>
      <th scope="col">Content</th>
      <th scope="col">Status</th>
      <th scope="col">CreatedAt</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="note" items="${noteList}">
    <tr>
      <th>${note.noteId}</th>
      <td>${note.noteTitle}</td>
      <td>${note.noteContent}</td>
      <td>${note.noteStatus}</td>
      <td>${note.createdAt }</td>
      <td><div class="btn-group" role="group" aria-label="Basic example">
			<a href="<c:url value="/updateNote/${note.noteId}" />"><button
							type="button" class="btn btn-success">Edit</button></a> <a
									href="<c:url value="/deleteNote/${note.noteId}" />"><button
										type="button" class="btn btn-danger">Delete</button></a>

							</div>
						</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
	</div>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
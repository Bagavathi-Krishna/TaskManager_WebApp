<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


<div class="container">
	<h1>YOUR TODOS:</h1>

	<table class="table">
		<thead>
			<tr>
			
				<th>Description</th>
				<th>TargetDate</th>
				<th>Status</th>
				<td></td>
				<td></td>

			</tr>
		</thead>

		<tbody class="table-group-divider">
			<c:forEach items="${l1}" var="todo">
				<tr>

					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.status}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-primary">Add ToDo</a>
</div>
<%@ include file="common/trailer.jspf"%>


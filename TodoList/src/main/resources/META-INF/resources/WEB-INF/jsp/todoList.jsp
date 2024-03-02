<%@ include file="common/header.jspf" %>

	<%@ include file="common/navigation.jspf" %> 
	
		<div class="container">
			<h1>${name} manage your Todos here: </h1>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>End Date</th>
						<th>Status</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.endDate}</td>
							<td>${todo.status}</td>
							<td> <a href="deleteTodo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
							<td> <a href="updateTodo?id=${todo.id}" class="btn btn-success">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="addTodos" class="btn btn-success">Add Todo</a>
		
		</div>
<%@ include file="common/footer.jspf" %>

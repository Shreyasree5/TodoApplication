<%@ include file="common/header.jspf" %>

	<%@ include file="common/navigation.jspf" %> 
	
		<div class="container">
			<h1>Your Todos are </h1>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
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
							<td>${todo.id}</td>
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

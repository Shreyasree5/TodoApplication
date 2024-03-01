<%@ include file="common/header.jspf" %>

	    <%@ include file="common/navigation.jspf" %>
	    
		<div class="container">
			<h1>Enter Todo Details</h1>
			
			<form:form method="post" modelAttribute="todo">
			
			    <fieldset class="mb-3">
				    <form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
			    </fieldset>
			    
			    <fieldset class="mb-3">
				    <form:label path="endDate">End Date</form:label>
					<form:input type="text" path="endDate" required="required"/>
					<form:errors path="endDate" cssClass="text-warning"/>
			    </fieldset>
			
				<input type="submit" class="btn btn-success"/>
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="status"/>
				
			</form:form>
	
		</div>
		
<%@ include file="common/footer.jspf" %>
		
		<script type="text/javascript">
		
			$('#endDate').datepicker({
			    format: 'yyyy-mm-dd'
			});
			
		</script>

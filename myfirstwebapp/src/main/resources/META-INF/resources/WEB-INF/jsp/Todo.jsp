<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>

	<div class="container">
		<h1>Add a task!!</h1>
		<form:form method="post" modelAttribute="todo" class="container">
			<fieldset class="mb-3"> 
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" /> 
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mb-3"> 
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="date" path="targetDate" /> 
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="status" />
			<input type="submit" class="btn btn-primary" />
		</form:form>


	</div>
<%@ include file="common/trailer.jspf" %>
		
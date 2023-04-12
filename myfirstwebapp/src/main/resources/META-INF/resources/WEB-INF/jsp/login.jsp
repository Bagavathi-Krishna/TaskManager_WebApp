<%@ include file="common/header.jspf" %>
	<div class-=container>
		<h1>LOGIN</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name"><br> <br>
			Password: <input type="password" name="password"> <br> <input
				type="submit">
		</form>
	</div>
<%@ include file="common/trailer.jspf" %>
		
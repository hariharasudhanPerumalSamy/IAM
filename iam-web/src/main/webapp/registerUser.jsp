<%@page import="fr.tbr.iamcore.datamodel.User"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String msg = request.getParameter("error");
	if (msg.equals("registrationSuccessful")) {
		out.println("<script>");
		out.println("alert('Registration Successful!');");
		out.println("location='index.jsp';");
		out.println("</script>");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
	href="css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div xmlns="http://www.w3.org/1999/xhtml" class="bs-example">
			<form role="form" method="post" action="Register">
				<div class="form-group">
					<label for="exampleInputEmail1">User Name</label> <input
						name="userName" type="text" class="form-control"
						id="exampleInputEmail1" placeholder="Enter UserName" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						name="password" type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Enter Password" />
				</div>

				<button type="submit" class="btn btn-default">Register</button>

			</form>

		</div>
	</div>
</body>
</html>
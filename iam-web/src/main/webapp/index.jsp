<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<% 
	
	String msg = request.getParameter("error");
	if (msg != null) {
		out.println("<script>alert('Login Failed!');</script>");
	}
%>

<html>
<head>
<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
	href="css/bootstrap.min.css" />
</head>

<body>
	<div class="container">
		<div xmlns="http://www.w3.org/1999/xhtml" class="bs-example">
			<form role="form" method="post" action="Login">
				<div class="form-group">
					<label for="exampleInputEmail1">Login</label> 
					<input name="login" type="text" class="form-control" id="exampleInputEmail1"
						placeholder="Enter Login" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> 
					<input name="password" type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" />
				</div>

				<tbody>
                    <tr>
				<button type="submit" class="btn btn-default">Login</button>
				<a href="registerUser.jsp?error=">Register Here</a>
				</tr>
				</tbody>
                
			</form>
		</div>
	</div>
</body>
</html>

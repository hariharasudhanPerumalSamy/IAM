<%@page import="fr.tbr.iamcore.datamodel.Identity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<% Identity id = (Identity)session.getAttribute("identity");

String msg = request.getParameter("msg");
if (msg.equals("saveUnSuccessful")) {
	out.println("<script>alert('Email is Mandatory!');</script>");
}else if(msg.equals("saveUnSuccessful")){
	id = null;
	session.removeAttribute("identity");
}
%>
<head>
<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
	href="css/bootstrap.min.css" />
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
</head>

<body>
    <h1>Identity Creation</h1>
	<div class="container">
		<div xmlns="http://www.w3.org/1999/xhtml" class="bs-example">
			<form role="form" method="post" action="IdAction">
				<div class="form-group">
					<label for="exampleInputEmail1">Display Name</label> 
					<input name="displayName" type="text" class="form-control" id="exampleInputEmail1"
						placeholder="Enter Display Name" <%
						if(id != null){
						%>
						value='<%=id.getDisplayName()%>'
						<% 	
						}
						%>/>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email*</label> 
					<input name="email" type="text" class="form-control" id="exampleInputEmail1"
						placeholder="Enter Email" <%
						if(id != null && !id.getEmail().equals("")){
						%>
						value='<%=id.getEmail()%>'
						readOnly="readonly"
						<% 	
						}
						%>/>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">UID</label> 
					<input name="uid" type="text" class="form-control" id="exampleInputEmail1"
						placeholder="Enter UID" <%
						if(id != null){
						%>
						value='<%=id.getUid()%>'
						<% 	
						}
						%>/>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">BirthDate</label> 
					<input name="birthDate" type="date" id="datepicker" class="form-control" id="exampleInputEmail1"
						placeholder="Date of Birth" <%
						if(id != null){
						%>
						value='<%=id.getBirthDate()%>'
						<% 	
						}
						%>/>
				</div>
				

				<button type="submit" class="btn btn-default">Save</button>
			</form>
		</div>
	</div>
</body>
</html>

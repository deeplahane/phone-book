<%@page import="com.connector.Connect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.entities.Message"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body style="background-color: #F2F3F5;">

	 <%
		if(user==null){
			Message m=new Message("Please Login First","alert-danger");
			session.setAttribute("msg", m);
			response.sendRedirect("login_page.jsp");
		}
	%> 
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>">
		<%=m.getContent()%>
	</div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<h3>
							<i class="fa-solid fa-plus"></i> Add Contact
						</h3>
					</div>
					<div class="card-body">
						<form action="add_pnumber" method="post">
						<input type="hidden"  value="<%=user.getId() %>" name="userId" />
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name </label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Jhon Doe "
									name="name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="jhondoe@gmail.com"
									name="email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Phone Number</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="1234567890" name="pnumber">
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3"
									id="exampleInputPassword1" placeholder="Add Note..."
									name="note"></textarea>
							</div>

							<button type="submit"
								class="btn btn-primary btn-block badge-pill">ADD</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
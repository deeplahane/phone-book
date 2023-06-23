<%@page import="com.entities.Contact"%>
<%@page import="com.connector.Connect"%>
<%@page import="com.dao.ContactDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.entities.Message"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
</head>
<body style="background-color: #F2F3F5;">
	<%
	if (user == null) {
		Message m = new Message("Please Login First", "alert-danger");
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
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	ContactDAO dao = new ContactDAO(Connect.getCon());
	Contact c = dao.getContactById(id);
	%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<h3>
							<i class="fa-solid fa-pen-to-square"></i> Edit Contact
						</h3>
					</div>
					<div class="card-body">
						<form action="update_contact" method="post">
							<input type="hidden" name="id" value="<%=c.getId()%>" />
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name </label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Jhon Doe "
									name="name" value="<%=c.getName()%>">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="jhondoe@gmail.com"
									name="email" value="<%=c.getEmail()%>">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Phone Number</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="1234567890" name="pnumber"
									value="<%=c.getPnumber()%>">
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3"
									id="exampleInputPassword1" placeholder="Add Note..."
									name="note"><%=c.getNote()%></textarea>
							</div>

							<button type="submit"
								class="btn btn-primary btn-block badge-pill">Save</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
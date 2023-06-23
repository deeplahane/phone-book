<%@page import="com.entities.Contact"%>
<%@page import="java.util.List"%>
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
<title>view contacts</title>
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
	Message msg = (Message) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert <%=msg.getCssClass()%>" role="alert">
		<%=msg.getContent()%>
	</div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div class="container-fluid  login-container">
		<div class="row">
			<div class="col-md-12"
				style="display: flex; align-items: center; justify-content: center;">
				<%
				ContactDAO contact = new ContactDAO(Connect.getCon());
				List<Contact> c = contact.getContactsById(user.getId());
				
				for (Contact v : c) {
				%>

				<div class="card-deck">
					<div class="card ">
						<div class="card-block">
							<div class="card-header "> 
								<h6 class="mt-2"><%=v.getName()%></h6>
							</div>
							<div class="card-body">


								<p>
									<b>Phone no:</b>
									<%=v.getPnumber()%>
								</p>
								<p>
									<b>Email:</b>
									<%=v.getEmail()%>
								</p>
								<p>
									<b>Note:</b>
									<%=v.getNote()%>
								</p>
								<div class="text-center">
									<a href="edit_contact.jsp?id=<%=v.getId() %>" type="submit"
										class="btn btn-secondary btn-sm">Edit</a> <a href="delete?id=<%=v.getId()%>"
										type="submit" class="btn btn-danger btn-sm">Delete</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>
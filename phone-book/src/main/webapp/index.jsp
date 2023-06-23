<%@page import="com.connector.Connect"%>
<%@page import="com.entities.Message"%>
<%@page import="java.sql.Connection"%>
<%-- <%@page import="com.connect.Connector"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
	background:
		url("https://img.freepik.com/free-vector/contact-concept-landing-page_52683-20526.jpg?w=996&t=st=1687437126~exp=1687437726~hmac=f92cbbe36097425ad33246ef0c4b5907c7bdf0ff903db5d4b82f96e8837e488a");
	height: 68vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: contain;
}
</style>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%-- <%
	Connection conn = Connect.getCon();
	if (conn != null) {
		out.print(conn);
	} else {
		out.print("error");
	}
	%> --%>
	
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
	<div class="alert <%=m.getCssClass()%>"><%=m.getContent()%></div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div
		style="display: flex; align-items: center; justify-content: center;"
		class="m-4 p-2 ">
		<div class="container-fluid con-hom">
			<div class="text-center">
				<h1 class="home-div ">
					<i class="fa-solid fa-phone"></i> Phone Book
				</h1>
			</div>
		</div>
		<div class="container-fluid back-img con-hom"></div>
	</div>
	<%@ include file="components/footer.jsp"%>
</body>
</html>

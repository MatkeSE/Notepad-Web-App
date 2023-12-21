<%@page import="com.User.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnection"%>
<%@page import="com.DAO.NoteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDtls user3 = (UserDtls) session.getAttribute("userD");

if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<h2>All notes:</h2>

		<div class="row">
			<div class="col-md-12">

				<%
				if (user3 != null) {
					NoteDAO ob = new NoteDAO(DBConnection.getConn());
					List<Note> note = ob.getData(user3.getId());
					for (Note no : note) {
				%>
				<div class="card mt-3">

					<img alt="" src="img/images.jpg" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">

					<div class="card-body p-4">

						<h5 class="card-title "><%=no.getTitle() %></h5>
						<p><%=no.getContent() %></p>

						<p>
							<b class="text-success">Published By: <%=user3.getName() %> </b><br> <b
								class="text-primary"></b>
						</p>
						<p>
							<b class="text-success">Published date: <%=no.getPdate() %> </b><br> <b
								class="text-primary"></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id" class="btn btn-danger">Delete</a>
							<a href="edit.jsp?note_id" class="btn btn-primary">Edit</a>
						</div>

					</div>

				</div>
				<%
				}
				}
				%>


			</div>
		</div>

	</div>

</body>
</html>
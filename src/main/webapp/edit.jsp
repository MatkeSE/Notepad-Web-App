<%@page import="com.User.Note"%>
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

<%
Integer noteid = Integer.parseInt(request.getParameter("note_id"));

NoteDAO note = new NoteDAO(DBConnection.getConn());
Note n = note.getDataByID(noteid);

%>



<div class="container-fluid p-0">
		<%@include file="all_component/navbar.jsp"%>

		<h1 class="text-center">Edit Your Notes</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="EditNoteServlet" method="post">
						<div class="form-group">

							
							<input type="hidden" value = "<%=noteid %>" name ="noteid">


							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								name="title" required="required" aria-describedby="emailHelp" value="<%=n.getTitle() %>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1"></label>
							<textarea rows="8" cols="" class="form-control"
							 name="content"
								required="required" ><%=n.getContent()%></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add notes</button>
						</div>

					</form>
				</div>
			</div>
		</div>

	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>
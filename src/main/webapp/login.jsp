<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>


<body>

	<%@include file="all_component/navbar.jsp"%>


	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">

				<div class="card mt-4">
					<div class="card-header text-center">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Login Page</h4>
					</div>

					<%
					String invMsg = (String) session.getAttribute("log-failed");
					if (invMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=invMsg%></div>
					<%
					session.removeAttribute("log-failed");
					}
					%>

					<%
					String withoutLogin = (String) session.getAttribute("Login-error");
					if (withoutLogin != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
					session.removeAttribute("Login-error");
					}
					%>
					
					<%
					String lgMsg=(String)session.getAttribute("logoutMsg");
					if(lgMsg!=null)
					{%>
					<div class="alert alert-success" role="alert"><%=lgMsg%></div>
					<%
					session.removeAttribute("logoutMsg");
					}
					%>


					<div class="card-body">
						<form method="post" action="loginServlet">

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>


	<%@include file="all_component/footer.jsp"%>

</body>
</html>
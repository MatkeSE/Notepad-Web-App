package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnection;
import com.User.UserDtls;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDtls us = new UserDtls();
		us.setEmail(email);
		us.setPassword(password);

		UserDAO dao = new UserDAO(DBConnection.getConn());
		boolean f = dao.loginUser(us);

		if (f) {
			response.sendRedirect("home.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("log-failed", "Invalid email or password");
			response.sendRedirect("login.jsp");
		}

	}

}

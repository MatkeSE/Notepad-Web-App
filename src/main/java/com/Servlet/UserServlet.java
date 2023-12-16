package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.DAO.UserDAO;
import com.Db.DBConnection;
import com.User.UserDtls;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("fname");
		String email=req.getParameter("ueamil");
		String password=req.getParameter("upassword");
		
		UserDtls us=new UserDtls();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnection.getConn());
		boolean f=dao.addUser(us);
	    
		HttpSession session;
		
		if(f)
		{
			session=req.getSession();
			session.setAttribute("reg-success", "Registration success!");
			resp.sendRedirect("register.jsp");
		}
		else
		{
			session=req.getSession();
			session.setAttribute("reg-failed", "Something went wrong!");
			resp.sendRedirect("register.jsp");
		}
	}

	
}

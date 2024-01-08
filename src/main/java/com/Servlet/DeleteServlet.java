package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.NoteDAO;
import com.Db.DBConnection;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer noteid = Integer.parseInt(request.getParameter("note_id"));
		NoteDAO dao = new NoteDAO(DBConnection.getConn());
		
        boolean f=dao.DeleteNotes(noteid);
	    
		HttpSession session=null;
		
		if(f)
		{
			session=request.getSession();
			session.setAttribute("updateMsg", "Notes are deleted!");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("wrongMsg", "Something went wrong!");
			response.sendRedirect("showNotes.jsp");
		}
		
		
	}


}

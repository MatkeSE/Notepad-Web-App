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


@WebServlet("/EditNoteServlet")
public class EditNoteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		try {
			
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			NoteDAO dao  = new NoteDAO(DBConnection.getConn());
			boolean f = dao.NoteUpdate(noteid, title, content);
			
			if(f)
			{
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Note successfully updated.");
				response.sendRedirect("showNotes.jsp");
			}
			
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

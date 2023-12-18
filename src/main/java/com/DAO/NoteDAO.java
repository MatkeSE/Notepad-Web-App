package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.User.Note;

public class NoteDAO {

	private Connection conn;

	public NoteDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean AddNotes(String ti,String co,int ui)
	{
		boolean f=false;
		
		try {
			
		String sql="insert into note(title,content,uid) value(?,?,?)";	
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, ti);
		ps.setString(2, co);
		ps.setInt(3, ui);
		
		int i=ps.executeUpdate();
		if(1==i)
		{
			f=true;
		}
			
		}
		catch 
		(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}

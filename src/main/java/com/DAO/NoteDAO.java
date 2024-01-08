package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;

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
	
	public List<Note> getData(int id)
	{
		List<Note> list = new ArrayList<Note>();
		Note n=null;
		
		try {
			String sql="select * from note where uid=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				n=new Note();
              n.setId(rs.getInt(1));
              n.setTitle(rs.getString(2));
              n.setContent(rs.getString(3));
              n.setPdate(rs.getTimestamp(4));
              list.add(n);
              
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Note getDataByID(int noteId)
	{
		Note n = null;
		try {
			
			String sql = "select * from note where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, noteId);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next())
			{
				n = new Note();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setContent(rs.getString(3));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public boolean NoteUpdate(int nid , String ti, String co)
	{
		boolean f = false;
		
		try {
			
			String sql = "update note set title=?,content=? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);
			int i = ps .executeUpdate();
			
			if(i==1) {f=true;}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean DeleteNotes(int nid)
	{
		boolean f = false;
        
		try {
		String sql  = "delete from note where id= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, nid);
		 
		 int i =ps.executeUpdate();
		 
		if(i == 1)
		{
			return true;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return f;
	}
	
	
}

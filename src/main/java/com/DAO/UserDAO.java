package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDtls;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDtls us)
	{
		boolean f=false;
		
		try {
			
			String sql="insert into user(name,email,password) values (?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		} catch
		(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public UserDtls loginUser(UserDtls us)
	{
		UserDtls user=null;
		
		try {
			
			String sql="select * from user where email=? and password=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			ResultSet rs=ps.executeQuery();
			
			
			
			if(rs.next())
			{
				user = new UserDtls();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch
		(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
}

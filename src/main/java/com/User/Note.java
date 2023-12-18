package com.User;

import javax.xml.crypto.Data;

public class Note {
	
	private int id;
	private String title;
	private String content;
	private Data pdate;
	private UserDtls user;
	public Note(int id, String title, String content, Data pdate, UserDtls user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pdate = pdate;
		this.user = user;
	}
	public Note() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Data getPdate() {
		return pdate;
	}
	public void setPdate(Data pdate) {
		this.pdate = pdate;
	}
	public UserDtls getUser() {
		return user;
	}
	public void setUser(UserDtls user) {
		this.user = user;
	}
	
	

}

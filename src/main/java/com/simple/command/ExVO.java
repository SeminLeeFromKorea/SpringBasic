package com.simple.command;

public class ExVO {

	private String id;
	private String pw;
	
	public ExVO() {
		// TODO Auto-generated constructor stub
	}

	public ExVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "ExVO [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}

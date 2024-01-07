package com.myweb.model;

public class Category {
	private int id;
	private String title;
	private String status;
	
	public Category() {
	}

	public Category(String title, String status) {
		super();
		this.title = title;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

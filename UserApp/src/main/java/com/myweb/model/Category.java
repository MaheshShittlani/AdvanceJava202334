package com.myweb.model;

public class Category {
	private int id;
	private String title;
	private String status;
	private String createdAt;
	private String updateAt;
	
	public Category() {
	}

	public Category(String title, String status) {
		super();
		this.title = title;
		this.status = status;
	}

	public Category(int id, String title, String status, String createdAt, String updateAt) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return id + " | " + title + " | "+status;
	}
}

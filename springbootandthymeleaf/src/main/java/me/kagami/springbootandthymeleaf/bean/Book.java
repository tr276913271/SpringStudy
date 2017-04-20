package me.kagami.springbootandthymeleaf.bean;

import org.hibernate.validator.constraints.NotBlank;

public class Book {
	private String name;
	@NotBlank
	private String author;
	private int uid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

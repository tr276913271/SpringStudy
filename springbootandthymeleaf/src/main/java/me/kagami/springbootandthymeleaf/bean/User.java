package me.kagami.springbootandthymeleaf.bean;

public class User {
	private int id = 1;
	private String name = "tian";
	private String password = "12345";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

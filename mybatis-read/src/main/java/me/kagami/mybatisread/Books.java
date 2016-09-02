package me.kagami.mybatisread;

import org.apache.ibatis.type.Alias;

@Alias(value="Books")
public class Books {
	private int id;
	private String book;

	public Books() {
		super();
	}

	public Books(int id, String book) {
		super();
		this.id = id;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + "]";
	}

}

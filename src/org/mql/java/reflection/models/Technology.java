package org.mql.java.reflection.models;

import org.mql.java.reflection.annotations.Form;

@Form(title = "Nouvelle Technologie")

public class Technology {
	private int id;
	private String name;
	private int year;
	private String author;
	private String description = "";
	
	public Technology() {
		// TODO Auto-generated constructor stub
	}

	
	public Technology(int id, String name, int year, String author) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.author = author;

	}


	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", year=" + year + ", author=" + author + "description =" + description + "]";
	}


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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}

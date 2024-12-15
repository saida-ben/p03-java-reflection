package org.mql.java.reflection.models;

import java.io.Serializable;

import org.mql.java.reflection.annotations.Form;
import org.mql.java.reflection.annotations.TextField;

@Form
public class Product implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@TextField(label="Identificateur", size=15)

	private int id;
	@TextField(label="Designation")

	private String name;
	@TextField(label="Prix", size=10)

	private int price;
	
	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}

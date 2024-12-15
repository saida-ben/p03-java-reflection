package org.mql.java.serailisation;

import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;

import org.mql.java.reflection.models.Product;

public class Test {
	public Test() {
		exp01();
	}
	
	 void exp01() {
		try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ressources/products.dat"));
		Product p1 = new Product(101, "Clavier", 380);
		out.writeObject(p1); //serialisation de  l'objet p1
		out.close();

	}catch (Exception e) {
		e.printStackTrace();
	}	
	}
	 
	 void exp02() {
		ObjectInput in;
		//deserialisation

	}
	
	public static void main(String[] args) {
		new Test();
	}
}

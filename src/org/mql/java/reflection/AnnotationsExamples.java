package org.mql.java.reflection;


import javax.swing.JFrame;

import org.mql.java.actions.EditAction;
import org.mql.java.actions.FileAction;
import org.mql.java.reflection.models.Product;
import org.mql.java.reflection.models.Technology;
import org.mql.java.reflection.ui.Form;
import org.mql.java.reflection.ui.Menu;

public class AnnotationsExamples extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public AnnotationsExamples() {
		exp03();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//pack();
		setSize(500,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void exp01() {
		Form f = new Form("Nouveau Produit" , 120);
		f.add("Identificateur" , 10);
		f.add("Designation", 30);
		f.add("Prix unitaire", 15);
		setContentPane(f);

	}
	
	void exp03() {
		Menu menu = new Menu();
		menu.add(new FileAction());
		menu.add(new EditAction()); //components scan (analyse package et extraire les classes ) 
		setJMenuBar(menu); // proble introspection (prb d'ordre)
	}
	
	void exp02() {
		Form f = FormGenerator.generate(new Product());
		setContentPane(f);

	}
	public static void main(String[] args) {
		new AnnotationsExamples();
	}

}

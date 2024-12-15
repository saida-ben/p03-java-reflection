package org.mql.java.reflection.ui;

import javax.swing.JFrame;

import org.mql.java.actions.EditAction;
import org.mql.java.actions.FileAction;


public class TestMenu extends JFrame{

	private static final long serialVersionUID = 1L;

	public TestMenu() {
		exp01();
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void exp01() {
		
		Class<?>[] actionClasses = { FileAction.class, EditAction.class }; 
		Menu menu = new Menu();
		for(Class<?> cls : actionClasses) {
			try {
				Object instance = cls.getDeclaredConstructor().newInstance();
				menu.add(instance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		setJMenuBar(menu);
	}
	
	public static void main(String[] args) {
		new TestMenu();
	}
}

package org.mql.java.reflection;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.mql.java.reflection.dao.DataSource;
import org.mql.java.reflection.models.Product;
import org.mql.java.reflection.models.Technology;

/*
 * Reflexion ou Introspection (reflection)
 * 
 */
public class Examples {

	public Examples() {
		exp03();
	}

	
	void exp01() {
		Technology t1 = new Technology(100, "Fortran", 1937, "John Backus");
		scan(t1);
		System.out.println(t1);
	}
	
	void scan(Object obj) {
		Class<?> cls = obj.getClass();
		
		System.out.println("Name" + cls.getName());
		System.out.println("Simple Name" + cls.getSimpleName());
		
		Field fields[] = cls.getDeclaredFields();
 
		for(Field field : fields) {
			try {
				field.setAccessible(true); // => autorisation pour : .get(obj)
				
				System.out.println(" - " + field.getName() + " : " + field.get(obj)); // pas besoin d'autorisation pour acceder a la structure de classe(determiner les champs / methods ...)  pour acceder a la valeur de champs ou le modifier vous avez besoin d'auto
				
				if(field.getName().equals("description")) {
					field.set(obj, "ceci est une desc");
				}
				
				field.setAccessible(false);
			} catch (Exception e) {
				System.out.println("Erreur" + e.getMessage());
			}
		}
	}
	
	void exp02() {
		// Une classe
		Class<?> cls = Product.class;
		Method methods[] = cls.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println(" - " + method.getName() + "()");
		}
	}
	
	void exp03() {
		// Nom de classe
		Properties props = new Properties();
		
		try {
			props.load(new FileReader("ressources/application.properties")); // class abstraite java.io  line number reader
		}catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
		System.out.println(props);
		String ds = props.getProperty("data-source");
		System.out.println(ds);
		
		Class<?> cls = null;
		DataSource dataSource = null;
		
		try {
			cls = Class.forName(ds);
			dataSource = (DataSource)cls.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
		if(dataSource != null) {
			dataSource.getConnection();	
		}
		
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}

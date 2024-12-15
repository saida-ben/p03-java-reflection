package org.mql.java.reflection;

import java.io.File;

public class PckageExploerer {
	
	public PckageExploerer() {
		scan("org.mql.java.reflection");//recuperer classpath
	}
	
	public void scan(String packageName) {
		
		String classPath = System.getProperty("java.class.path");
		System.out.println(classPath);
		String packagePath = packageName.replace(".", "\\");
		System.out.println(packagePath);
		String path = classPath + "\\" + packagePath;
		
		File dir = new File(path);
		File content[] = dir.listFiles();
		
		for (int i = 0; i < content.length; i++) {
			String name = packageName + "." + content[i].getName().replace(".class", "");
			System.out.println(" - "+name);
		}
		
	}
	
	public static void main(String[] args) {
		new PckageExploerer();
	}
	
}// l'introspection
 

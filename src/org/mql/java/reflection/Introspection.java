package org.mql.java.reflection;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Vector;

public class Introspection {
	public Introspection() throws ClassNotFoundException {
		modifier();
	}

	  public Vector getClassesParentes() throws ClassNotFoundException {

		    Vector cp = new Vector();
		    
		    Class examples = Class.forName("org.mql.java.reflection.Examples");
		    Class superClasse;

		    cp.add(examples.getName());
		    superClasse = examples.getSuperclass();
		    
		    while (superClasse != null) {
		      cp.add(0,superClasse.getName());
		      examples = superClasse;
		      superClasse = examples.getSuperclass();
		    }
		    
	        System.out.println("Hiérarchie des classes : " + cp);

		    return cp;
		  }
	  public Vector modifier() throws ClassNotFoundException {
		    Class examples = Class.forName("org.mql.java.reflection.Examples");
		    Vector cp = new Vector();
		  
		  int m = examples.getModifiers();
		  if(Modifier.isPublic(m)) cp.add("publique");
		  if(Modifier.isPrivate(m)) cp.add("private");
		  if(Modifier.isAbstract(m)) cp.add("abstract");
		  System.out.println(cp);
		  return cp;
		  }
	      public static void main(String[] args) throws ClassNotFoundException {
	    	  new Introspection();
		
		
	      }

}

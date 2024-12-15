package org.mql.java.reflection.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.mql.java.enumerations.Separator;
import org.mql.java.reflection.annotations.Controller;
import org.mql.java.reflection.annotations.RequestMapping;



//menu avec swing
// 3 classes pour creer menu jmenubar  conteneur principale d'un menu est un jmenubar
public class Menu extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	private String path = "ressources/icons/";
	private String type = ".gif";
	
   public Menu() {
		
	 }
   
	public Menu(String m[][]) {
		for (int i = 0; i < m.length; i++) {
			add(m[i]);
		}
	 }
	
  public void add(String t[]) {
	  JMenu m = new JMenu(t[0]);
	  add(m);
	  for (int i = 1; i < t.length; i++) {
		  ImageIcon icon = new ImageIcon(path + t[i] + type);
		  JMenuItem item = new JMenuItem(t[i], icon);
		  m.add(item);
	}
  }
  
   public void add(Object obj) {
	  Class<?> cls = obj.getClass();
      Controller ctrl = cls.getDeclaredAnnotation(Controller.class);
      JMenu m = new JMenu(ctrl.value());
      add(m);
      
      List<Method> annotatedMethods = new ArrayList<>();
      
      Method methods[] = cls.getDeclaredMethods();
      for(Method method : methods) {
    	  if(method.isAnnotationPresent(RequestMapping.class)) {
    		  annotatedMethods.add(method);
    	  }
      }
      
      Collections.sort(annotatedMethods, new Comparator<Method>() {
    	  @Override
    	  public int compare(Method m1, Method m2) {
    		  int key1 = m1.getAnnotation(RequestMapping.class).key();
    		  int key2 = m2.getAnnotation(RequestMapping.class).key();
    		  return Integer.compare(key1, key2);
    	  }
     });
      
      
      for (Method method : annotatedMethods) {
          RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
          
          if (requestMapping.separator() == Separator.BEFORE) {
              m.addSeparator();
          }
    		  ImageIcon icon = new ImageIcon(path + requestMapping.icon() + type);
    		  JMenuItem item = new JMenuItem(requestMapping.name(), icon);
    		  m.add(item);
    		  item.addActionListener(new Action(obj, method));
    		  
    	        if (requestMapping.separator() == Separator.AFTER) {
    	            m.addSeparator();
    	        }
	}
  }
 

  
  
  private class Action implements ActionListener{
	  private Object obj;
	  private Method method;
	  
	public Action(Object obj, Method method) {
		super();
		this.obj = obj;
		this.method = method;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object result = method.invoke(obj);
			System.out.println("result =" +result);
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	  
  }
  
}

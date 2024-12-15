package org.mql.java.actions;

import org.mql.java.enumerations.Separator;
import org.mql.java.reflection.annotations.Controller;
import org.mql.java.reflection.annotations.RequestMapping;

@Controller("Edit")
public class EditAction {
	
	public EditAction() {
	}
	
    @RequestMapping(name = "Copy", icon = "copy", key = 1,separator= Separator.AFTER)
	public String copy () {
		System.out.println("Copy");
		return "copy.jsp";
		
	}
	
    @RequestMapping(name = "cut", icon = "cut", key = 2, separator= Separator.AFTER)
	public String cut () {
		System.out.println("cut");
		return "cut.jsp";
		
	}
    
    @RequestMapping(name = "paste", icon = "paste", key = 3)
	public String paste () {
		System.out.println("paste");
		return "paste.jsp";
		
	}
	

}

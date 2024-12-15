package org.mql.java.actions;

import org.mql.java.enumerations.Separator;
import org.mql.java.reflection.annotations.Controller;
import org.mql.java.reflection.annotations.RequestMapping;

@Controller("File")
public class FileAction {
	
	public FileAction() {
	}
	
    @RequestMapping(name = "New File", icon = "newFile", key = 1, separator= Separator.AFTER)
	public String newFile() {
		System.out.println("Create a new File");
		return "new-file.jsp";
	}
    
    @RequestMapping(name = "open a File", icon = "open", key = 2, separator= Separator.AFTER)
	public String open() {
		System.out.println("open a File");
		return "open.jsp";
	}
    
    @RequestMapping(name = "Save File", icon = "save", key = 3, separator= Separator.AFTER)
	public String save() {
		System.out.println("Save File");
		return "save.jsp";
	}
	
    @RequestMapping(name = "New File", icon = "save", key = 4,separator= Separator.AFTER)
	public String saveAs() {
		System.out.println("Save as a new  File");
		return "save-as.jsp";
	}
	
    @RequestMapping(name = "Exit File", icon = "exit", key = 5)
	public String exit() {
		System.out.println("Exit the app");
		return "exit.jsp";
	}


	public static void main(String[] args) {
		
	}
}

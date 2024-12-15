package org.mql.java.reflection;

import java.lang.reflect.Field;

import org.mql.java.reflection.annotations.TextField;
import org.mql.java.reflection.ui.Form;

//moteur de traitement de l'annotaion Form


public class FormGenerator {
	
	public FormGenerator() {
		
	}
	
	public static Form generate(Object obj) {
		Class<?> cls = obj.getClass();
		
	org.mql.java.reflection.annotations.Form form = cls.getDeclaredAnnotation(org.mql.java.reflection.annotations.Form.class);
		
		if(form != null) {
			String title = form.title();
			//risque de terminer en erreur si title est null on fait constance avant la variable
			if("".equals(title)) {
				title = cls.getSimpleName();
			}
			
			Form f = new Form(title, form.labelSize());
			Field fields[] = cls.getDeclaredFields();
			
			for(Field field : fields) {
				TextField tfa = field.getDeclaredAnnotation((TextField.class));
				if(tfa !=null) {
					String label = tfa.label();
					if("".equals(label)) label = field.getName();
					f.add(label, tfa.size());
				}
			}
			
			return f;
		}
		return null;
	}
}

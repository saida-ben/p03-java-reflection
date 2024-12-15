package org.mql.java.reflection.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value = {ElementType.TYPE, ElementType.FIELD}) // 3 niv(src .class execution(runtime))

@Target(ElementType.TYPE) //1er raccourci si il y a un seul element on fait pas {} si il y a un seul att et qui est value donc on l ecrit pas
@Retention(RetentionPolicy.RUNTIME)


public @interface Form {
	String title() default "" ; //default "e";           // att d'annotation => les types autorises (primitifs, enum, String, annotation, tableau de ceci )
	int labelSize() default 100 ;
}

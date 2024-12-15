package org.mql.java.enumerations;

import java.awt.Color;

// ce sont des constantes de type basicColor 
// type enumere c est un class on peut pas l instancier  // contructeur private pas public 
// j ai pas le droit de charger et ecraser la constante mais je peux le modifier
public enum BasicColor {
	BLACK, 
	WHITE(Color.white),
	BLUE(Color.blue),
	CYAN(Color.cyan),
	RED(Color.red),
	GREEN(Color.green) ,
	YELLOW(Color.yellow);
	
	private Color value = Color.black;
	
	private BasicColor() {
		
	}
	
	private BasicColor(Color value) {
		this.value = value;
	}

	public Color getValue() {
		return value;
	}

	public void setValue(Color value) {
		this.value = value;
	}
	
	
	
}

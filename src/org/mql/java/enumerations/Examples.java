package org.mql.java.enumerations;

public class Examples {

	public Examples() {
		exp01();
	}
	
    void exp01() {
		// TODO Auto-generated method stub
    	BasicColor c1 = BasicColor.BLUE;
    	System.out.println("c1 = " +c1);
    	System.out.println(BasicColor.YELLOW.name());
    	System.out.println(BasicColor.YELLOW.ordinal());
    	System.out.println(BasicColor.BLACK.ordinal());
    	System.out.println(BasicColor.RED);
    	
    	String color = "GREEN";
    	BasicColor c2 = BasicColor.valueOf(color);
    	System.out.println("c2 = "+c2);
    	System.out.println(c2.getValue());

	}
    
    void exp02() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		new Examples();

	}

}

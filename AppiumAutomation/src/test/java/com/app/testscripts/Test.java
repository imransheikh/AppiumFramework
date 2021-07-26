package com.app.testscripts;

public class Test {

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void testMethod()
	{
		/*
		 * String s = "$167"; String[] tokens = s.split("$"); int k=
		 * Integer.parseInt(s.replaceAll("$", "")); System.out.println("Test: " + k );
		 * for (String t : tokens) System.out.println(t);
		 */
		
		String str = "$167";
		int nbr = 1;
		str = str.replaceAll("^.{" + nbr + "}", "");//Output = amaica
		System.out.println(str);
		
		
		//String s="200";  
		//Converting String into int using Integer.parseInt()  
		//float i=(float)(Integer.parseInt(s));
		//Printing value of i  
		//System.out.println(Integer.parseInt(s)); 
		
		String s = "200.87";
		double d = Double.parseDouble(s);
		int i = (int) d;
		System.out.println(d); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Test obj= new Test();
		obj.testMethod();
		
	}
}

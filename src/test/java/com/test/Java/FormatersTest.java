package com.test.Java;

import java.util.Formatter;

public class FormatersTest {

	public static void main(String[] args) {
		//using printf()
		/*System.out.printf("my name is %s and my age is %d", "Ankush",24);
		System.out.println();
		
		
		//using Formatter class
		Formatter fmt=new Formatter();
		fmt.format("my name is %s and my age is %d","ankush",24);
		String x=fmt.toString();
		System.out.println(x);
		
		//using String.format() method
		String y=String.format("my name is %s and my age is %d", "Ankush",24);
		System.out.println(y);
		
		//using StringBuilder
		StringBuilder sb=new StringBuilder();
		Formatter fm=new Formatter(sb);
		fm.format("my name is %s and my age is %d", "Ankush",24);
		String z=fm.toString();
		System.out.println(z);
		
		//used priority 3$,2$,1$
		String a="first second third";
		System.out.printf("%2$s %3$s %1$s","first","second","third");*/
		
		//reverse order
		String name="Hello i am waiting";
		String[] y=name.split(" ");
		for(int i=3;i>=0;i--) {
			System.out.print(y[i]+" ");		
		}
		
		String m="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=m.length()-1;i>=0;i--) {
			char k=m.charAt(i);
			System.out.print(k); 
		}
	}

}

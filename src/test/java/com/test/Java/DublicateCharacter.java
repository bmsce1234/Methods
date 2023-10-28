package com.test.Java;

public class DublicateCharacter {

	public static void main(String[] args) {
		String x="abdul kalam";
		char a[]=x.toCharArray();
		char c='a';
		int count=0;
		for(char l:a) {
			if(c==l) {
				count++;
			}
		}
		
		System.out.println(c+"="+count);

	}

}

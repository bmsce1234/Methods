package com.test.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterOccurence {
	                                                         
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter sentence:: ");
		String sentence=sc.nextLine();
		sc.close();
		//abdul kalam
		Map<Character, Integer> hm=new HashMap<Character,Integer>();
		
		for(int i=0;i<sentence.length();i++) {
			if(hm.containsKey(sentence.charAt(i))) {
				hm.put(sentence.charAt(i),hm.get(sentence.charAt(i))+1);
			}else {
				hm.put(sentence.charAt(i), 1);	
			}
		}
		
		System.out.println(hm);
	}
}

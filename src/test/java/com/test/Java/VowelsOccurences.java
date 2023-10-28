package com.test.Java;

import java.util.HashMap;

public class VowelsOccurences {

	public static void main(String[] args) {
		String x="i am indian in india ouuo";
		
		HashMap<Character, Integer> hm=new HashMap<>();
		hm.put('a', 0);
		hm.put('e', 0);
		hm.put('i', 0);
		hm.put('o', 0);
		hm.put('u', 0);
		
		for(int i=0;i<x.length();i++) {
			if(hm.containsKey(x.charAt(i))) {
				hm.put(x.charAt(i), hm.get(x.charAt(i))+1);
			}
		}
		
		System.out.println(hm);
		
		int max=0;
		char v=0;
		for(char c:hm.keySet()) {        //char c='a';  //c='e'  // c='i' c='o'  c='u'
			if(hm.get(c)>max) {          //2>0          //0>2    //6>2    2>6    2>6
				max=hm.get(c);           //max=2                 //max=6
			    v=c;
			}
		}
		System.out.println(v+"="+max);

	}

}

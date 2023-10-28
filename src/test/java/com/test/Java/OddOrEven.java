package com.test.Java;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int num=sc.nextInt();
		sc.close();
		
		if(num%2==0) {
			System.out.println("even number");
		}else {
			System.out.println("odd number");
		}

	}

}

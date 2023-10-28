package com.test.Java;

public class UsingOperatorSwapping {
	
	public static void main(String[] args) {
		int x=25;
		int y=50;
		
		/*System.out.println(x=x^y);   25/2=12=1   12/2=6=0 6/2=3=0  3/2=1=1  00011001
		System.out.println(y=x^y);     50/2=25=0                              00110010
		System.out.println(x=x^y);*/                                      //  ----------
		                                                                  //  0   0   1   0   1   0   1   1        
		/*int z=x;                                                        // 2(7)2(6)2(5)2(4)2(3)2(2)2(1)2(0)     
		x=y;                                                              //---------------------------------
		y=z;                                                              //  0+ 0+ 32+  0+ 8+   +0+ 2+ 2=44=x
		System.out.println(x);
		System.out.println(y);*/
		                                                                  //0   0   1   1   0   0   1   0
		/*System.out.println(x=x*y);                                      //0   0   1   0   1   0   1   1
		System.out.println(y=x/y);                                         -------------------------------
		System.out.println(x=x/y);*/                                      // 0   0   0  1    1   0   0  1
		                                                                  // 0+  0+  0+ 16+  8+  0+  0+ 1=25=y
		/*System.out.println(x=x+y);
		System.out.println(y=x-y);                                      //0   0   1   0   1   0   1   1 =x
		System.out.println(x=x-y);*/                                    //0   0   0  1    1   0   0  1  =y
		                                                                 //-------------------------------------
		                                                                 // 0   0   1   1   0   0   1   0
		                                                                 // 0+  0+  32+ 16+ 0+  0+  2+  0=50=x

	}

}
